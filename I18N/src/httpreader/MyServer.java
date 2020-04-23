package httpreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    //获取请求头信息内容
    public static void main(String[] args) {
        try {
            //1 建立自己的服务
            ServerSocket server = new ServerSocket(9999);
            Socket socket = server.accept();
            //2 准备输入流读取
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            //3 读取一行
            String value = reader.readLine();
            //4 输出读取到的内容
            while(value!=null && ""!=value){
                System.out.println(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
