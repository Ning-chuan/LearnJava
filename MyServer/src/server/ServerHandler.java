package server;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

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
        //调用controller干活
        ServletController.findController(request,response);
        //经过上面的调用 真实Controller类里的service方法应当执行了
        //response应当已经写入了响应信息 调用方法将response返回给浏览器处理
        this.responseToBrowser(response);
    }



    //将结果返回给浏览器
    private void responseToBrowser(HttpServletResponse response){
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.println(response.getResponseContent());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
