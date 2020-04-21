package controller;

import service.AtmService;
import spring.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DepositController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 设置接受字符集
        req.setCharacterEncoding("UTF-8");
        //2 获取名字和存款金额
        String aname = req.getParameter("aname");
        String depositMoney = req.getParameter("depositMoney");
        //3 调用service层存款方法
        AtmService service = MySpring.getBean("service.AtmService");
        service.deposit(aname,depositMoney);
        //4 存款之后页面恢复到登陆时的样子
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.write("<html>");
        out.write(" <head>");
        out.write("     <meta charset=\"UTF-8\">");//浏览器按照此字符集解析
        out.write(" </head>");
        out.write(" <body>");
        out.write("     ===============================<br>");
        out.write("     ======= 欢迎"+aname+"进入银行系统 =======<br>");
        out.write("     ===============================<br>");
        out.write("     请输入操作项<br>");
        out.write("     <a href=\"inquiry?aname="+aname+"\">查询</a><br>");
        out.write("     <a href=\"depositPage?aname="+aname+"\">存款</a><br>");
        out.write("     <a href=\"\">取款</a><br>");
        out.write("     <a href=\"\">转账</a><br>");
        out.write(" </body>");
        out.write("</html>");
        out.flush();
    }
}
