package controller;

import service.AtmService;
import spring.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class InquiryController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        //0 设置组装字符集
        //浏览器会按照事先规定好的字符集(UTF-8)吧请求的汉字拆成字节 我们要按照这个字符集再组装回去
        requset.setCharacterEncoding("UTF-8");
        //1 获取参数
        String aname = requset.getParameter("aname");
        if(aname==null){
            HttpSession session = requset.getSession();
            aname = (String)session.getAttribute("aname");
        }
        //2 调用service层的查询方法
        AtmService service = MySpring.getBean("service.AtmService");
        Float abalance = service.inquiry(aname);
        //  我们想要吧业务层返回的abalance交给对应jsp展示出来 需要利用request下面的功能
        //  request对象中有两个map集合
        //  Map<String,String>  String value = request.getParameter("key");
        //  Map<String,Object>  Object value = request.getAttribute("key");
        requset.setAttribute("abalance",abalance);
        //3 将查询到的结果交给abalancePage处理
        requset.getRequestDispatcher("abalancePage.jsp").forward(requset,response);
    }
}
