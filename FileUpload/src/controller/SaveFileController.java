package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SaveFileController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            //用ServletFileUpload对象解析request
            List<FileItem> list = upload.parseRequest(req);
            for(FileItem item:list){
                if(item.isFormField()){ //是一个普通组件
                    String key = item.getFieldName();//获取组件的name属性
                    String value = item.getString("UTF-8");//获取组件的value属性
                    System.out.println(key+"----"+value);
                }else{//是一个文件

                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
