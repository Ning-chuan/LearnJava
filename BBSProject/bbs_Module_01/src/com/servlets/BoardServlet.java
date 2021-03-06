package com.servlets;

import dao.BoardDao;
import domain.Board;

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

        //2.调用dao层次方法
        List<Board> boards = boardDao.selectAllParentBoards();
        //3.存入对应作用域
        req.setAttribute("parentBoards",boards);
        //4.转发处理
        req.getRequestDispatcher("view/indexTemp.jsp").forward(req,resp);
    }
}
