package controller;

import service.AtmService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    AtmService atmService = new AtmService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String uname = req.getParameter("uname");
        String upassword = req.getParameter("upassword");
        if(uname==null && upassword==null){
            Cookie[] cookies = req.getCookies();
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("uname")){
                    uname = cookie.getValue();
                }
                if(cookie.getName().equals("upassword")){
                    upassword = cookie.getValue();
                }
            }
        }

        String result = atmService.login(uname,upassword);
        req.setAttribute("result",result);
        if(result.equals("登陆成功")){
            String[] values = req.getParameterValues("flag");
            if(values!=null && values.length>0){
                Cookie nameCookie = new Cookie("uname",uname);
                Cookie passwordCookie = new Cookie("upassword",upassword);
                nameCookie.setMaxAge(20);
                passwordCookie.setMaxAge(20);
                resp.addCookie(nameCookie);
                resp.addCookie(passwordCookie);
            }
            req.getRequestDispatcher("welcome.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
