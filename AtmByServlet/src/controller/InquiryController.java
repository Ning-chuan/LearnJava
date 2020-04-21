package controller;

import service.AtmService;
import spring.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InquiryController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 设置组装字符集
        //浏览器会按照事先规定好的字符集(UTF-8)吧请求的汉字拆成字节 我们要按照这个字符集再组装回去
        req.setCharacterEncoding("UTF-8");
        String aname = req.getParameter("aname");
        //2 调用service层的查询方法
        AtmService service = MySpring.getBean("service.AtmService");
        Float abalance = service.inquiry(aname);
        //3 将查询到的结果写回浏览器
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.write("<html>");
        out.write(" <head>");
        out.write("     <meta charset=\"UTF-8\">");//浏览器按照此字符集解析
        out.write("     <script type=\"text/javascript\">");
        out.write("         window.onload = function () {");
        out.write("             var backButton = document.getElementById('back');");
        out.write("             backButton.onclick = function () {");
        out.write("                 window.history.back();");
        out.write("             }");
        out.write("         }");
        out.write("     </script>");
        out.write(" </head>");
        out.write(" <body>");
        out.write("     ==== 尊敬的"+aname+"，您的余额为：====<br>");
        out.write(      abalance+"<br>");
        out.write("     <input id=\"back\" type=\"button\" value=\"返回\">");
        out.write(" </body>");
        out.write("</html>");
        out.flush();
    }
}
