package controller;

import service.AtmService;
import spring.MySpring;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 设置接收字符集
        request.setCharacterEncoding("UTF-8");
        //2 获取请求参数
        String aname = request.getParameter("aname");
        String apassword = request.getParameter("apassword");
        //3 调用service层方法处理
        AtmService Service = MySpring.getBean("service.AtmService");
        String result = Service.login(aname,apassword);
        //4 找对应JSP处理返回页
        if(result.equals("登陆成功")) {
            //信息存入session以便后续使用
            HttpSession session = request.getSession();
            session.setAttribute("aname",aname);
            session.setAttribute("password",apassword);
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request,response);//真正转给welcome.jsp处理
        }else{

        }
    }
}
