package com.servlets;

import dao.BoardDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BoardServlet extends HttpServlet {

    BoardDao boardDao = new BoardDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //1.接参数

        //2.和dao打交道，拿到需要的数据
        System.out.println("进来了");
          // List parentBoards = boardDao.selectAllParentBoards();
        //System.out.println("几个父板块："+parentBoards.size());
        //3.把得到的东西，存到..
          // req.setAttribute("parentBoards",parentBoards);
        //4.跳转
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/indexTemp.jsp");
        dispatcher.forward(req,resp);

    }
}
