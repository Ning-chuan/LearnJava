package controller;

import domain.Country;
import service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebFault;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectAllCountry")
public class SelectAllCountryController extends HttpServlet {

    private CountryService service = new CountryService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用service层方法 从数据库查询出所有国家信息
        ArrayList<Country> countries = service.selectAllCountry();
        //把所有的国家信息存入request里
        req.setAttribute("countries",countries);
        //转发给注册页面展示
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }
}
