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
            //展示时间的方法: 参数一:容纳时刻的元素 参数二:时刻
            function showCountDown(timeELe, value) {
                if (value < 10) {
                    value = "0" + value;
                }
                $("#" + timeELe).text(value);
            }

            function startSeckill() {
                alert("秒杀开始!")
            }


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
                var serverTimeLong = result['data'];

                //时间检查:
                if (serverTimeLong >= endTime) {
                    //过了结束之间,提示一下,直接返回
                    alert("该商品的秒杀已然结束!")
                    return;
                }

                var timeGap = startTime- serverTimeLong;
                var intervalID = setInterval(function () {
                    if (timeGap <= 0){
                        //清除当前计时事件
                        clearInterval(intervalID)
                        //开始秒杀
                        startSeckill();
                        //返回当前函数,不再往后执行
                        return;
                    }
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
                    //更新时间差
                    timeGap = timeGap - 1000;
                }, 1000)

            })

        })
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

                <span class="st">后开始抢购</span>

            </div>
        </div>

    </div>
</div>
</body>
</html>
