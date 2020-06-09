package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9966);

            //告知服务器自己的id
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("百晓生");
            pw.flush();

//            //创建读、写线程
//            Thread reader = new Thread(new ClientReader(socket));
//            Thread writer = new Thread(new ClientWriter(socket));
//            //开启读、写线程
//            reader.start();
//            writer.start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
