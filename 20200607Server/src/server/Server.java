package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){
        try {
            ServerSocket server = new ServerSocket(9966);
            System.out.println("=======Server Star=======");
            Socket socket = server.accept();

            //创建读、写线程
            Thread reader = new Thread(new ServerReader(socket));
            Thread writer = new Thread(new ServerWriter(socket));
            //开启读、写线程
            reader.start();
            writer.start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
