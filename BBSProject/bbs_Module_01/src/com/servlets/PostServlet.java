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
        //  获取页码
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));

        //2.调用dao层次对应方法获取结果
        //  2.1查询所有置顶帖子
        List<Post> topPosts = postDao.queryTopPosts(boardId);
        //  2.2查询其余(除置顶帖之外)帖子
        int totalPage = postDao.getTotalPage(boardId);//获取总页码(除置顶帖)
        pageNo = postDao.correctPage(pageNo,totalPage);//纠正页码
        List<Post> otherPosts = postDao.queryOtherPosts(boardId,pageNo);


        //3.把结果存起来
        req.setAttribute("topPosts",topPosts);
        req.setAttribute("otherPosts",otherPosts);
        req.setAttribute("boardId",boardId);//板块id
        req.setAttribute("pageNo",pageNo);//页码
        req.setAttribute("totalPage",totalPage);//尾页（总页数）

        //4.转发处理
        req.getRequestDispatcher("pages/bbs/listRootShow.jsp").forward(req,resp);
    }
}
