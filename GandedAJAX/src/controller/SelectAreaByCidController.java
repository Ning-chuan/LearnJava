package controller;

import com.alibaba.fastjson.JSONObject;
import domain.Area;
import service.AreaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectAreaByCid")
public class SelectAreaByCidController extends HttpServlet {

    private AreaService service = new AreaService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request获取cid
        Integer cid = Integer.parseInt(req.getParameter("cid"));
        //调用service层方法获取对应的area集合
        ArrayList<Area> areaList = service.selectAreaByCid(cid);

        /*
        控制层利用另一个jsp+el+jstl处理 tomcat需要编译 性能不好
        //把area集合存入request
        req.setAttribute("areaList",areaList);
        //转发给jsp做拼接处理
        req.getRequestDispatcher("handleAreaList.jsp").forward(req,resp);
        */

        //利用json处理
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("areaList", areaList);
//        System.out.println(jsonObject);
//        System.out.println(jsonObject.toJSONString());
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonObject.toJSONString());

    }
}
