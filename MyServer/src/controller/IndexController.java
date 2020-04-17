package controller;

import server.HttpServletRequest;
import server.HttpServletResponse;

import java.util.HashMap;

public class IndexController {


    public void test(HttpServletRequest request, HttpServletResponse response){
        System.out.println("控制层启动！");

        System.out.println(request.getContent());
        System.out.println(request.getParamsMap());
    }
}
