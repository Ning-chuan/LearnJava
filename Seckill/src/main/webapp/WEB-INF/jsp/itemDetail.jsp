<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品秒杀</title>
    <%--导入公用内容 Bootstrap jQuery ... --%>
    <%@include file="common/head.jsp" %>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }

        #seckillItemDiv {
            margin-top: 3%;
        }

        #timeDiv {
            background-color: #D00414;
            line-height: 120px;
            margin: auto auto;
            text-align: center;
            border-radius: 10px;
        }

        .timeNum {
            color: #D00414;
            border-radius: 5px;
            border: 1px solid #440106;
            font-size: 45px;
            background-color: #440106;
        }

        .st {
            font-size: 18px;
            color: white;
        }
    </style>

    <script type="text/javascript">
        /*jQuery入口函数 网页中DOM结构加载完毕时执行*/
        $(function () {
            //格式化倒计时并展示 参数：事件差
            function formatTimeAndShow(timeGap) {
                //定义 天 时 分 秒
                var d, h, m, s;
                d = Math.floor(timeGap / 1000 / 60 / 60 / 24);
                h = Math.floor(timeGap / 1000 / 60 / 60 % 24);
                m = Math.floor(timeGap / 1000 / 60 % 60);
                s = Math.floor(timeGap / 1000 % 60);
                //展示计算出的时间
                showCountDown("sec_day", d);
                showCountDown("sec_hour", h);
                showCountDown("sec_min", m);
                showCountDown("sec_sec", s);
            }
            //展示时间的方法: 参数一:容纳时刻的元素 参数二:时刻
            function showCountDown(timeELe, value) {
                if (value < 10) {
                    value = "0" + value;
                }
                $("#" + timeELe).text(value);
            }

            function startSeckill() {
                alert("秒杀开始!");
                //设置秒杀按钮可用：
                $("#seckillBtn").removeClass("disabled");
            }


            //得到long类型的起始、结束时间
            var startTime = ${seckillItem.startTime.time};
            var endTime = ${seckillItem.endTime.time};
            // console.log(startTime);
            // console.log(endTime);
            //ajax请求 获取服务器当前时间
            $.get("/Seckill/getServerTime", {}, function (result) {
                // result json
                // {"success":true,"data":1595944752610,"message":"now long"}
                //服务器的当前时间
                //console.log(result);
                var serverTime = result['data'];

                //时间检查:
                if (serverTime >= endTime) {
                    //过了结束之间,提示一下,然后直接返回
                    alert("该商品的秒杀已然结束!")
                    return;
                }

                //计算当前时间和开始时间的时间差
                var timeGap = startTime - serverTime;
                //开启一个计时事件（活动开始倒计时）
                var toStartTimer = setInterval(function () {
                    if (timeGap <= 0){
                        //此时活动已经开始
                        //清除 活动开始倒计时 定时事件
                        clearInterval(toStartTimer)
                        //开始秒杀
                        startSeckill();
                        //准备开启另一个计时事件（活动结束倒计时）
                        // 修改展示文字：
                        $('#afterText').text("后结束抢购");
                        // 计算此刻距离活动结束的时间差，需要重新获取当前时间，依然从服务器获取：
                        $.get("/Seckill/getServerTime",{},function (result) {
                            serverTime = result['data'];
                            timeGap = endTime - serverTime;
                            //开启倒计时：
                            var toStopTimer = setInterval(function () {
                                if (timeGap <= 0) {
                                    //此时活动结束，清除结束倒计时
                                    clearInterval(toStopTimer);
                                    alert("活动结束！");
                                    //返回当前函数，不再继续执行
                                    return;
                                }
                                //格式化结束倒计时并展示
                                formatTimeAndShow(timeGap);
                                //更新时间差
                                timeGap = timeGap - 1000;
                            },1000);
                        });
                        //返回当前函数,不再往后执行
                        return;
                    }
                    //timeGap > 0 说明活动还没有开始
                    //格式化开始倒计时并展示
                    formatTimeAndShow(timeGap);
                    //更新时间差
                    timeGap = timeGap - 1000;
                }, 1000);

            });

        });
    </script>
</head>
<body>
<div class="container">

    <div id="seckillItemDiv" class="panel panel-danger">
        <!-- Default panel contents -->
        <div class="alert panel-heading">商品名称：${seckillItem.name}</div>
        <div class="alert alert-info" role="alert">秒杀价格：${seckillItem.price}</div>
        <div class="alert alert-info" role="alert">库存数量：${seckillItem.number}</div>

        <%--        当前场次 00 天 00 时 00 分 00 后结束抢购--%>
        <div id="seckillBox">
            <div id="timeDiv">
                <span class="st">当前场次</span>

                <span id="sec_day" class="timeNum">00</span>
                <span class="st">天</span>
                <span id="sec_hour" class="timeNum">00</span>
                <span class="st">时</span>
                <span id="sec_min" class="timeNum">00</span>
                <span class="st">分</span>
                <span id="sec_sec" class="timeNum">00</span>

                <span id="afterText" class="st">后开始抢购</span>

            </div>
        </div>
        <button id="seckillBtn" class="btn btn-primary disabled">开始抢购</button>


    </div>
</div>
</body>
</html>
