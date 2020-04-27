package controller;

import domain.Commodity;
import service.CommodityService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SelectCommodityController extends HttpServlet {

    CommodityService service = MySpring.getBean("service.CommodityService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //0 设置字符集 只需要接收kid 所以也可以不设置
        //1 获取参数
        Integer kid = Integer.parseInt(req.getParameter("kid"));
        //2 调用service层方法获取商品信息
        ArrayList<Commodity> commodityList = service.selectCommodity(kid);
        //3 存入request对象 转发给jsp展示
        req.setAttribute("commodityList",commodityList);
        req.getRequestDispatcher("showCommodity.jsp").forward(req,resp);
    }



}
