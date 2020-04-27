<%@ page import="domain.Kind" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript">
        window.onload = function () {
            var kindSelect = document.getElementById("kindSelect");
            kindSelect.onchange = function () {
                window.location.href = "SelectCommodity?kid="+this.value;
            }
        }
    </script>
    <title>welcome!</title>
</head>
<body>
    欢迎您进入购物系统！请选择商品种类：<br>
    <select id="kindSelect" name="kid">
            <option>==请选择==</option>
            <%
                ArrayList<Kind> kindList = (ArrayList<Kind>) request.getAttribute("kindList");
                for(Kind kind:kindList){
                    String kname = kind.getKname();
                    out.write("<option value=\""+kind.getKid()+"\">"+kname+"</option>");
                }
            %>
    </select>
</body>
</html>
