package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class SaveFileController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024*1024*1024);//设置缓冲区大小
            ServletFileUpload upload = new ServletFileUpload(factory);
            //upload.setFileSizeMax(10240000);设置单个上传文件大小
            upload.setSizeMax(1024*1024*1024);//设置上传文件总大小 1G

            //补充：upload可以设置一个监听上传进程的方法
            upload.setProgressListener(new ProgressListener() {
                public void update(long l, long l1, int i) {
                    //第一个参数 代表已经上传的字节数
                    //第二个参数 表示文件总字节数
                    //第三个参数 表示正在上传第几个组件
                }
            });

            //用ServletFileUpload对象解析request
            List<FileItem> list = upload.parseRequest(req);
            for (FileItem item : list) {
                if (item.isFormField()) { //是一个普通组件
                    String key = item.getFieldName();//获取组件的name属性
                    String value = item.getString("UTF-8");//获取组件的value属性
                    System.out.println(key + "----" + value);
                } else {//是一个文件
                    String key = item.getFieldName();//获取组件name属性
                    String fileName = item.getName();//获取文件真实名字
                    System.out.println(key + "---" + fileName);

                    //调用自己定义的判断文件类型的方法
                    if (this.isRightType(fileName)) {//是我们支持的类型

                        //item.write(new File("D://test/" + fileName));//放在固定位置 可移植性不好

                        //获取当前文件的根目录
                        String path = this.getServletContext().getRealPath("/");
                        //把文件写到当前工程的指定目录里
                        item.write(new File(path+"/WEB-INF/lib/"+fileName));

//                        //原生方式实现文件上传
//                        InputStream inputStream = item.getInputStream();//获取一个输入流  读取网络传递过来的文件内容
//                        OutputStream outputStream = new FileOutputStream("D://test/" + fileName);
//                        //输入流先读取到提前定义好的数组里
//                        byte[] b = new byte[1024];
//                        int length = inputStream.read(b);
//                        //通过循环把文件内容写出去
//                        while (length != -1) {
//                            //读到了内容 通过输出流写出去
//                            outputStream.write(b, 0, length);
//                            outputStream.flush();
//                            //继续读取
//                            length = inputStream.read(b);
//                        }
//                        outputStream.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //设计一个方法 自己控制上传文件的类型
    public boolean isRightType(String fileName) {
        //定义一个数组 记录自己支持的类型
        String[] types = {"jpg", "png", "", "txt", "ppt", "pptx"};
        for (int i = 0; i < types.length; i++) {
            if (fileName.endsWith(types[i])) {
                return true;
            }
        }
        return false;
    }
}
