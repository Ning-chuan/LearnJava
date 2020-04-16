package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    private void server(){
        try {
            System.out.println("=====服务开启=====");
            ServerSocket server = new ServerSocket();
            while(true) {
                //等待客户连接
                Socket socket = server.accept();
                //启动一个线程 负责处理当前浏览器发送过来的消息
                new ServerHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
