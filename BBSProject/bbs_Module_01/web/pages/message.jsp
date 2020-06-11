<%@ page contentType="text/html; charset=gb2312"%>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <title>友情提示</title>
    <base href="<%=basePath%>">
    <link style="text/css" rel="stylesheet" href="css/style.css">    
  </head>
  <body bgcolor="#F9FDFF">
    <center>
        <table border="0" width="325" height="223" cellpadding="0" cellspacing="0" style="margin-top:150">
            <tr>
                <td align="center" background="images/login/mess.gif">

                    <br><br>
                    <a href="javascript:window.history.go(-1)">返回</a>
                </td>
            </tr>
        </table>
    </center>
  </body>
</html>