package server;

import controller.IndexController;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;
import java.util.Properties;

public class ServerHandler extends Thread {

    private Socket socket;
    public ServerHandler(Socket socket){
        this.socket = socket;
    }


    public void run(){
        this.receiveRequest();
    }

    //接收消息
    private void receiveRequest(){
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            String contentAndParams = reader.readLine();

            //调用解析方法
            this.parseContentAndParams(contentAndParams);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //解析消息
    private void parseContentAndParams(String contentAndParams){
        String content = null;
        HashMap<String,String> paramsMap = null;

        int questionMarkIndex = contentAndParams.indexOf("?");
        if(questionMarkIndex!=-1){
            //说明携带了参数 需要继续解析
            content = contentAndParams.substring(0,questionMarkIndex);
            paramsMap = new HashMap<>();
            String params = contentAndParams.substring(questionMarkIndex+1);
            String[] keyAndValues = params.split("&");
            for(String keyAndValue:keyAndValues){
                String[] KV = keyAndValue.split("=");
                paramsMap.put(KV[0],KV[1]);
            }
        }else{
            //说明不携带参数
            content = contentAndParams;
        }
        //---------------至此解析完成 下一步调用findController干活----------------
        //this.findController(content,paramsMap);
        //为了更加通用 我们使用两个对象的方式处理参数 而不是上面的方式
        //一个对象用于包装请求的信息
        //另一个对象储存响应结果（返回给浏览器的信息） 这个对象刚开始是一个空对象
        HttpServletRequest request = new HttpServletRequest(content,paramsMap);
        HttpServletResponse response = new HttpServletResponse();
        this.findController(request,response);
    }

    //找Controller干活
    private void findController(HttpServletRequest request,HttpServletResponse response){
        try {
            //找到request对象里content属性之后利用反射找到对应的Controller控制器
            //我们需要的是content资源的类全名 但是url中不可能写类全名 原因如下
            //（因为在url中 . 符号后面的内容被认为是前面内容的类型 而不是路径）
            //所以我们需要自定义一个properties文件存储content资源对应的完整路径信息
            String content = request.getContent();
            Properties pro = new Properties();
            pro.load(new FileReader("src//web.properties"));
            String realControllerName = pro.getProperty(content);
            Class clazz = Class.forName(realControllerName);
            Object obj = clazz.newInstance();
            Method method = clazz.getMethod("test",HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(obj,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //将结果返回给浏览器
    private void returnToBrowser(){

    }
}
