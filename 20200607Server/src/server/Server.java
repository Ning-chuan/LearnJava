package server;

import domain.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Server {

    static Map<String, User> userMap = new HashMap<>();//存储连接的客户端信息

    public static void main(String[] args){
        try {
            ServerSocket server = new ServerSocket(9966);
            System.out.println("=======Server Star=======");

            while(true) {
                //等待一个客户端连接
                Socket socket = server.accept();
                //获取该客户端用户id/用户名
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String name = br.readLine();
                User user = new User(name,socket);
                //存入userMap
                userMap.put(name,user);
                //读取消息并转发消息（找线程做）
                new Thread(new ServerHandler(user)).start();
            }



            /*
            //创建读、写线程
            Thread reader = new Thread(new ServerReader(socket));
            Thread writer = new Thread(new ServerWriter(socket));
            //开启读、写线程
            reader.start();
            writer.start();
            */
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
