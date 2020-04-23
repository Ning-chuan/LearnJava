package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class TestController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //0 设置接收字符集
        req.setCharacterEncoding("UTF-8");
        //1 获取参数
        Enumeration en = req.getParameterNames();
        if(en.hasMoreElements()){
            String key = (String)en.nextElement();
            String value = req.getParameter(key);
            System.out.println(key+"---"+value);
        }
        StringBuffer url = req.getRequestURL();
        String uri = req.getRequestURI();
        System.out.println(url+"\n"+uri);

    }
}
