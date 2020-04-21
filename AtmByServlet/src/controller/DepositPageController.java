package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DepositPageController extends HttpServlet {
    //这个类负责动态展示存款页面
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 设置接受字符集
        req.setCharacterEncoding("UTF-8");

        String aname = req.getParameter("aname");

        resp.setCharacterEncoding("UTF-8");//设置响应字符集
        PrintWriter out = resp.getWriter();
        out.write("<html>");
        out.write(" <head>");
        out.write("     <meta charset=\"UTF-8\">");//浏览器按照此字符集解析
        out.write(" </head>");
        out.write(" <body>");
        out.write("     <form action=\"deposit\" method=\"get\">");
        out.write("         请输入存款金额：<input type=\"text\" name=\"depositMoney\" value=\"\"><br>");
        out.write("         <input type=\"hidden\" name=\"aname\" value=\""+aname+"\">");
        out.write("         <input type=\"submit\" value=\"确定\">");
        out.write("     </form>");
        out.write(" </body>");
        out.write("</html>");
        out.flush();
    }
}
