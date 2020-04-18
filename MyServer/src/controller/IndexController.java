package controller;

import server.HttpServlet;
import server.HttpServletRequest;
import server.HttpServletResponse;

public class IndexController extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response){
        System.out.println("控制层启动！");

        System.out.println(request.getParamsMap());
    }


}
