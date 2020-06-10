<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>REGISTER</title>
    <script type="text/javascript">
        window.onload = function () {
            //国家改变绑定事件 （选中了某个国家需要显示该国家的地区）
            document.getElementById("countrySelect").onchange = function () {
                //发送一个异步请求
                //1.创建一个对象
                var xmlhttp = new XMLHttpRequest();
                //2.打开一个AJAX连接 模拟一个异步请求
                //  参数一：请求方式：get/post
                //  参数二：请求名 可以用?拼接参数
                //  参数三：是否为异步请求：默认为true
                xmlhttp.open("post", "selectAreaByCid?cid=" + this.value, true);
                //3.发送请求
                xmlhttp.send();
                //4.观察响应状态 状态为4的时候 处理响应信息
                xmlhttp.onreadystatechange = function () {
                    if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                        /*
                        JSP+EL+JSTL处理：
                        //找到地区下拉列表标签
                        var areaSelectEle = document.getElementById("areaSelect");
                        //将响应信息放入这个标签
                        areaSelectEle.innerHTML = xmlhttp.responseText;
                        */

                        //JSON处理：
                        var areaSelectEle = document.getElementById("areaSelect");
                        areaSelectEle.options.length = 0;
                        var defaultOptionEle = document.createElement("option");
                        defaultOptionEle.innerHTML = "==请选择==";
                        areaSelectEle.appendChild(defaultOptionEle);

                        var responseText = xmlhttp.responseText;
                        var jsonObject = JSON.parse(responseText);
                        var areaList = jsonObject.areaList;
                        for(var i = 0;i < areaList.length; i++){
                            var area = areaList[i];
                            var newOptionEle = document.createElement("option");
                            newOptionEle.setAttribute("value",area.aid);
                            newOptionEle.innerHTML = area.aname;
                            areaSelectEle.appendChild(newOptionEle);
                        }

                        //为了避免城市下拉列表不同步 需要修改其innerHTML
                        document.getElementById("citySelect").innerHTML = "<option>==请选择==</option>";
                    }
                }
            }
            //地区改变绑定事件 (选中了某个地区时需要显示该地区的城市)
            document.getElementById("areaSelect").onchange = function () {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.open("get","selectCityByAid?aid="+this.value,true);
                xmlhttp.send();
                xmlhttp.onreadystatechange = function () {
                    if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                        /*
                        //找到城市下拉列表
                        var citySelectEle = document.getElementById("citySelect");
                        //将响应信息放入下拉列表标签
                        citySelectEle.innerHTML = xmlhttp.responseText;
                        */

                        //JSON处理
                        var citySelectEle = document.getElementById("citySelect");
                        citySelectEle.options.length = 0;
                        var defaultOptionEle = document.createElement("option");
                        defaultOptionEle.innerHTML = "==请选择==";
                        citySelectEle.appendChild(defaultOptionEle);

                        var responseText = xmlhttp.responseText;//获取异步响应信息
                        //console.log(responseText);
                        var jsonObject = JSON.parse(responseText);//JS对象---->与Java中的JSONObject对应的对象
                        var cityList = jsonObject.cityList;//JS对象---->对应Java中ArrayList<City>
                        for (var i = 0; i < cityList.length; i++) {
                            var city = cityList[i];
                            var newOptionEle = document.createElement("option");
                            newOptionEle.value = city.cityId;
                            newOptionEle.innerHTML = city.cityName;
                            citySelectEle.appendChild(newOptionEle);
                        }

                    }
                }
            }
        }
    </script>
</head>
<body>
    <form action="" method="post">
        账号：<input type="text" name="name" value=""><br>
        密码：<input type="text" name="password" value=""><br>
        确认：<input type="text" name="password1" value=""><br>
        性别：
        <input type="radio" name="sex" value="男">男
        <input type="radio" name="sex" value="女">女
        <br>
        国家：
        <select id="countrySelect">
            <option>==请选择==</option>
            <c:forEach var="country" items="${requestScope.countries}">
                <option value="${country.cid}">${country.cname}</option>
            </c:forEach>
        </select>
        地区：
        <select id="areaSelect">
            <option>==请选择==</option>
        </select>
        城市：
        <select id="citySelect">
            <option>==请选择==</option>
        </select>
        <br>
        电话：<input type="text" name="phoneNum" value=""><br>
        邮箱：<input type="text" name="email" value=""><br>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
    </form>
</body>
</html>
