package controller;

import service.AtmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController{

    AtmService atmService = new AtmService();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //2.获取请求参数
        String aname = req.getParameter("aname");
        String apassword = req.getParameter("apassword");
        //3.调用service方法
        String result = atmService.login();
        //4.转发
        req.getRequestDispatcher("").forward(req,resp);
    }


}
