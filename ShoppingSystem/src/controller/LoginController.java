package controller;

import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //0 设置接收字符集
        req.setCharacterEncoding("UTF-8");
        //1 获取参数
        String uname = req.getParameter("uname");
        String upassword = req.getParameter("upassword");
        //2 调用service层方法
        UserService service = MySpring.getBean("service.UserService");
        String result = service.login(uname,upassword);
        //
        if("登陆成功".equals(result)){
            req.getRequestDispatcher("welcome.jsp").forward(req,resp);
        }else{
            //把登陆失败的信息返回给浏览器展示给用户  通过request对象
            req.setAttribute("result",result);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
