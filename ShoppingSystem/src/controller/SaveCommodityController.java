package controller;

import domain.Commodity;
import service.CommodityService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class SaveCommodityController extends HttpServlet {
    //这个类是为了保存每次选择的商品
    private CommodityService commodityService = MySpring.getBean("service.CommodityService");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //0 设置接收字符集
        req.setCharacterEncoding("UTF-8");
        //1 获取商品编号
        String[] allCid = req.getParameterValues("cid");
        if(allCid != null || allCid.length != 0) {
            //如果条件满足，说明这次选择的商品>=0
            //2 把商品存入session里
            //      获取session对象
            HttpSession session = req.getSession();
            //      获取存储商品对象的集合（购物车）
            ArrayList<Commodity> shoppingCar = (ArrayList<Commodity>) session.getAttribute("shoppingCar");
            if (shoppingCar == null) {
                shoppingCar = new ArrayList();
                session.setAttribute("shoppingCar", shoppingCar);
            }
            //      遍历选中的商品id 找到对应商品并存入购物车中
            for (String cid : allCid) {
                Commodity commodity = commodityService.selectOne(Integer.parseInt(cid));
                shoppingCar.add(commodity);
            }
        }
        //2 判断请求是继续购物还是结算 分开处理
        String flag = req.getParameter("flag");
        if("继续购物".equals(flag)){
            //转到种类选择页面
            req.getRequestDispatcher("welcome.jsp").forward(req,resp);
        }else{
            //展示所有shoppingCar商品和总价
            req.getRequestDispatcher("showShoppingCarAndTotalPrice.jsp").forward(req,resp);
        }

    }
}
