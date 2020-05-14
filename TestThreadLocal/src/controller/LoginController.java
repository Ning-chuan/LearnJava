package controller;

import domain.User;
import service.AtmService;
import util.ThreadLocalManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    AtmService atmService = new AtmService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String uname = req.getParameter("uname");
        String upassword = req.getParameter("upassword");

        String result = atmService.login(uname,upassword);

        if(result.equals("登陆成功")){
            ThreadLocal local = ThreadLocalManager.getThreadLocal(uname);
            User user = (User)local.get();
            req.setAttribute("nickname",user.getNickname());
            req.getRequestDispatcher("welcome.jsp").forward(req,resp);
        }


    }
}
