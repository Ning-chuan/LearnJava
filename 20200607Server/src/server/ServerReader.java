package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 接收消息的线程
 */
public class ServerReader implements Runnable {

    private Socket socket;

    public ServerReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;//字节流转换为字符流
        BufferedReader br = null;
        try {
            //1.获取流
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            //2.读取、展示消息
            while(true) {
                String resp = br.readLine();
                System.out.println(resp);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("客户端离线了");
        } finally {
            //3.关闭资源
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr != null) isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
