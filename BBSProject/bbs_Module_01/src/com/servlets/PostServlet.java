package com.servlets;

import dao.PostDao;
import domain.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PostServlet extends HttpServlet {

    private PostDao postDao = new PostDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接参数
        //  获取要查询帖子的板块id
        Integer boardId = Integer.parseInt(req.getParameter("boardId"));
        //2.调用dao层次对应方法获取结果
        List<Post> postList = postDao.queryAllPosts();
        //3.把结果存起来

        //4.转发处理
    }
}
