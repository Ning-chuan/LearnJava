package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class DownloadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取文件名
        String fileName = req.getParameter("fileName");
        //通过文件名拼接地址 创建一个输入流 准备读取目标文件
        InputStream inputStream = new FileInputStream("D:/test/"+fileName);
        //设置文件名中文的编码方式  （上面因为获取文件名之后直接使用的 所以可以不采取措施）
        fileName = URLEncoder.encode(fileName,"UTF-8");

        //设置响应contentType
        resp.setContentType("application/x-msdownload");
        resp.setHeader("Content-disposition","attachment;filename="+fileName);

        //获取输出流把文件写回给浏览器
        OutputStream out = resp.getOutputStream();
        byte[] b = new byte[1024];
        int length = inputStream.read(b);
        while(length != -1){
            out.write(b,0,length);
            out.flush();
            length = inputStream.read(b);
        }
    }
}
