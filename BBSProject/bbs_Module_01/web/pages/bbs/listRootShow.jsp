<%@ page contentType="text/html; charset=gb2312"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>显示某版面中的所有帖子</title>
  </head>
  <body>
    <center>
      <table border="1" width="100%" cellspacing="0" cellpadding="0" bordercolor="#E0E0E0" bordercolorlight="#E3E3E3" bordercolordark="white" rules="rows" style="margin-top:8">          
          <tr height="45" bgcolor="#F9F9F9">
              <!-- 版面公告 -->
              <td colspan="4" style="text-indent:10">
                  版面公告：
              </td>
              <!-- “发表帖子”超链接 -->
              <td colspan="2" align="center"><a href="needLogin/addBbs.do?method=addBbs">[发表帖子]</a></td>
          </tr>
          
          <!-- 版面跳转 -->
          <tr height="30" bgcolor="#F9F9F9">

              <td colspan="6" align="right" background="images/index/boardE.jpg">
                  <input type="hidden" name="method" value="rootListShow">
                  跳转版面:

                  &nbsp;
              </td>

          </tr>
          
          <!-- ****************显示置顶帖子**************** -->
          <tr height="30"><td colspan="6" style="text-indent:5" background="images/index/classT.jpg"><b><font color="white">■ 置顶帖子</font></b></td></tr>
          <tr height="30" align="center">
              <td width="8%">状态</td>
              <td width="35%">帖子标题</td>
              <td width="7%">回复数</td>
              <td width="22%">发表者</td>
              <td width="28%" colspan="2">最后回复</td>
          </tr>
          <!-- 置顶帖子列表不存在 -->
          <c:if test="${empty topPosts}">
              <tr height="70"><td bgcolor="#F9F9F9" align="center" colspan="6"><font color="red"><li>置顶帖子列表不存在！</li></font></td></tr>
          </c:if>

          <!-- 置顶帖子列表存在 -->
          <c:if test="${not empty topPosts}">
                  <tr>
                      <td colspan="6">
                          <table border="1" width="100%" cellspacing="0" cellpadding="0" bordercolor="#F0F0F0" bordercolorlight="#F0F0F0" bordercolordark="white" rules="all">
                              <!-- 遍历置顶帖子列表 -->
                              <c:forEach items="${topPosts}" var="topPost">
                                  <tr height="35" style="text-indent:5" bgcolor="#FBFBFB">
                       			      <td width="8%" align="center">${topPost.status}</td>
			                          <td width="35%" style="text-indent:10">                             
            			                  <img src="images/face/bbs/">
                        			      <a href="">${topPost.title}</a>
			                          </td>
            			              <td width="7%" align="center"></td>
                        			  <td width="22%" align="center">
			                              <a href="">
            			                      <b></b>
                        			          <br>
                			              </a>
			                          </td>
            			              <td width="28%" align="center" colspan="2">
                        			      <a href="">
		                            	      <b></b>
        		                        	  <br>
                        			      </a>
    			                      </td>                          
                			      </tr>
                              </c:forEach>
			              </table>
			          </td>
			      </tr>
          </c:if>
          <tr height="30"><td colspan="6" align="right" background="images/index/boardE.jpg"></td></tr>
          
          <!-- ****************显示普通帖子**************** -->
          <tr height="30"><td colspan="6" style="text-indent:5" background="images/index/classT.jpg"><b><font color="white">■ 其他帖子</font></b></td></tr>
          <tr height="30" align="center" bgcolor="#F4F4F4">
              <td width="8%">状态</td>
              <td width="35%">帖子标题</td>
              <td width="7%">回复数</td>
              <td width="22%">发布者</td>
              <td width="22%">最后回复</td>
              <td width="6%">操作</td>
          </tr>
          <!-- 普通帖子列表不存在 -->
          <c:if test="${empty otherPosts}">
              <tr height="180"><td bgcolor="#F9F9F9" align="center" colspan="6"><font color="red"><li>对不起，帖子列表不存在！</li></font></td></tr>
          </c:if>

          <!-- 普通帖子列表存在 -->
          <c:if test="${not empty otherPosts}">
                  <tr>
                      <td colspan="6">
                          <table border="1" width="100%" cellspacing="0" cellpadding="0" bordercolor="#F0F0F0" bordercolorlight="#F0F0F0" bordercolordark="white" rules="all">
			 	              <!-- 遍历普通帖子列表 -->
                              <c:forEach items="${otherPosts}" var="otherPost">
			                      <tr height="35" bgcolor="#F9F9F9">
            			              <!-- 输出帖子状态 -->
            			              <td align="center" width="8%">
                                            ${otherPost.status}
			                          </td>
			                          <!-- 输出帖子标题 -->
            			              <td style="text-indent:10" width="35%">
                        			      <img src="images/face/bbs/${otherBbsSingle.bbsFace}">
			                              <a href="">${otherPost.title}</a>
            			              </td>
            			              <!-- 输出帖子回复数 -->
    			                      <td align="center" width="7%"></td>
                			          <!-- 输出帖子发表者 -->
                			          <td align="center" width="22%">
                            			  <a href="">
			                                  <b></b>
        		                        	  <br>
                        			      </a>
    			                      </td>
                			          <!-- 输出最后回复者 -->
                			          <td align="center" width="22%">
                            			  <a href="">
			                                  <b></b>
            			                      <br>
                        			      </a>
			                          </td>
			                          <!-- “删除”超链接 -->
            			              <td align="center" width="6%"><a href="" title="楼主/管理员操作" onclick="javaScript:return confirm('确认要删除该信息?')">×删除</a></td>
			                      </tr>
                              </c:forEach>
		                  </table>
	                  </td>
	              </tr>
          </c:if>

          <tr height="10" bgcolor="#F4F4F4"><td colspan="6" align="right"></td></tr>                    
          <!-- ****************分页导航栏**************** -->
          <tr height="30">
              <td colspan="6" align="right" background="images/index/boardE.jpg">
                  <table border="0" width="100%" cellspacing="0">
                      <tr>
                          <td width="37%" align="center">





                                  <a href="postServlet?boardId=${boardId}&pageNo=1">第一页</a>&nbsp;&nbsp;<a href="postServlet?boardId=${boardId}&pageNo=${pageNO-1}">上一页</a>




                              &nbsp;&nbsp;

                                  <a href="postServlet?boardId=${boardId}&pageNo=${pageNo+1}">下一页</a>&nbsp;&nbsp;<a href="postServlet?boardId=${boardId}&pageNo=${totalPage}">尾页</a>
                              &nbsp;&nbsp;&nbsp;&nbsp;

                          </td>
                          <td align="center" width="37%">
                              <form action="" method="post" name="form1">
                                  <select name="pageNo" onchange="">
                                  </select>
                              </form>
                          </td>



                          <form action="bbs_board" method="post">
                              <td width="26%">
                                  转到：
                                  <input type="hidden" name="boardId" value="${boardId }">
                                  <input type="text" name="pageNo" size="7">
                                  <input type="submit" value="跳转页面2">
                              </td>
                          </form>
                      </tr>
                  </table>
              </td>
          </tr>
          <tr height="10" bgcolor="#F4F4F4"><td colspan="6" align="right"></td></tr>
      </table>
    </center>
  </body>
</html>