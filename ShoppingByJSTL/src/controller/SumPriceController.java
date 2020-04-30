package controller;

import domain.Commodity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class SumPriceController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArrayList<Commodity> shoppingCar = (ArrayList<Commodity>) session.getAttribute("shoppingCar");
        int total = 0;
        for(Commodity commodity:shoppingCar){
            total += commodity.getCprice();
        }
        session.setAttribute("total",total);
        req.getRequestDispatcher("showShoppingCarAndTotalPrice.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
