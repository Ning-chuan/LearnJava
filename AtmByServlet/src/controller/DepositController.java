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
        req.getRequestDispatcher("welcome.jsp").forward(req,resp);
    }
}
