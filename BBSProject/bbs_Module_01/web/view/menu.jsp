<%@ page contentType="text/html; charset=gb2312"%>
<%@ page import="java.util.Date" %>


<%
    String[] weekdays={"","日","一","二","三","四","五","六"};
    String[] days=new String[42];
    for(int i=0;i<42;i++)
    	days[i]="";

    Date currentDay = new Date();
    int year=1900+currentDay.getYear();
    int month=currentDay.getMonth();
    int today=currentDay.getDate();
    int weekday=currentDay.getDay()+1;
    
    String now=year+"年"+(month+1)+"月"+today+"日"+" 星期"+weekdays[weekday];
%>

<html>
  <head>
    <title>页眉</title>
    <script type="text/javascript">
        function showTime(showWhere){
            var now=new Date();
	        var hour=now.getHours();
	        var minu=now.getMinutes();
	        var sec=now.getSeconds();
         
            if(hour<10) hour="0"+hour;
         	if(minu<10) minu="0"+minu;
         	if(sec<10) sec="0"+sec;
         	
         	showWhere.value=hour+":"+minu+":"+sec;
            setTimeout("showTime(time)",1000)
        }
      </script>
  </head>
  <body onload="showTime(time)" bgcolor="#F0F0F0">
    <center>
      <table border="0" width="100%" cellspacing="0" cellpadding="0" style="margin-top:1">
        <tr height="38">
            <td colspan="2" background="images/index/menu.jpg">
              <table border="0" width="100%" height="100%" cellspacing="0" cellpadding="0">
                <tr height="50%" style="font-size:10pt">
                    <td align="center">
                        <%=now %>
                        <input type="text" style="border:0;background-color:#F7F7F7" disable="true" id="time" size="9">
                    </td>
                    <td align="center" width="8%"><a href="">首 页</a></td>
                    <td align="center" width="8%"><a href="">登 录</a></td>
                    <td align="center" width="10%"><a href="">我的帖子</a></td>
                    <td align="center" width="10%"><a href="">精华帖子</a></td>
                    <td align="center" width="10%"><a href="">进入后台</a></td>
                    <td align="center" width="8%"><a href="">注 册</a></td>
                    <td align="center" width="8%"><a href="">注 销</a></td>
                </tr>                
              </table>
            </td>
        </tr>
        <tr height="40">
            <td width="529" align="center" background="images/index/indexP.jpg">                
                <marquee 
			      onmouseover=this.stop()
				  onmouseout=this.start()				  
                  scrollamount="1"
				  scrolldelay="10"
				  direction="left"
				  width="470">
				  <img src="images/index/pcard.gif"> 在线服务热线：(0451)8491*** E-mail：tsoft***@tsoft.com
		        </marquee>
            </td>
            <td align="center" width="271" background="images/index/messages.jpg">

            </td>
        </tr>
        <form action="/user/search.do" method="post">
        <input type="hidden" name="validate" value="yes">
        <tr height="38">
            <td colspan="2" background="images/index/indexS.jpg" align="center">
                <table border="0" width="98%">
                    <tr>
                        <td width="50%">
                        	欢迎登录：

                        		游客，您还没有登录！

                        </td>
                        <td align="right">                                        
			                条件：
            			    <select property="subsql">
			                    <options collection="searchSQL" property="value" labelProperty="label"/>
            			    </select>
			                关键字：
            			    <text property="sqlvalue" size="30"/>
			                <radio property="searchType" value="like">模糊</radio>
			                <radio property="searchType" value="all">精确</radio>
               				<submit value=" " style="background-image:url('images/index/bs.jpg');width:49;height:21;border:0"/>
                        </td>
                    </tr>                    
                </table>
            </td>
        </tr>
        </form>
      </table>
    </center>
  </body>
</html>