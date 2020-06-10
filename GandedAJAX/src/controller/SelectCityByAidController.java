package controller;

import com.alibaba.fastjson.JSONObject;
import domain.City;
import service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectCityByAid")
public class SelectCityByAidController extends HttpServlet {
    private CityService service = new CityService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request获取aid
        int aid = Integer.parseInt(req.getParameter("aid"));
        //调用service层方法 查出该地区id对应的所有城市
        ArrayList<City> cityList = service.selectCityByAid(aid);


        /*
        //把结果存入request
        req.setAttribute("cityList",cityList);
        //转给jsp处理拼接
        req.getRequestDispatcher("handleCityList.jsp").forward(req,resp);
        */

        //JSON处理
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cityList", cityList);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonObject.toJSONString());


    }
}
