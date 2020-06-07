package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9966);

            //创建读、写线程
            Thread reader = new Thread(new ClientReader(socket));
            Thread writer = new Thread(new ClientWriter(socket));
            //开启读、写线程
            reader.start();
            writer.start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
