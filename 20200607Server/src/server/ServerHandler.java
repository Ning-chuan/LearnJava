package server;

import domain.User;
import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 这个线程处理一个客户端发送过来的消息(读取、转发)
 */
public class ServerHandler implements Runnable {

    private User user;

    public ServerHandler(User user) {
        this.user = user;
    }

    public void run() {

        Set<Map.Entry<String, User>> users = Server.userMap.entrySet();


        try {
            while (true) {
                //读取消息
                BufferedReader br = new BufferedReader(new InputStreamReader(user.getSocket().getInputStream()));
                String mess = br.readLine();

                System.out.println(user.getId() + "说：" + mess);//测试用

                //转发
                Iterator<Map.Entry<String, User>> it = users.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, User> u = it.next();
                    PrintWriter pw = new PrintWriter(u.getValue().getSocket().getOutputStream());
                    pw.println(user.getId() + ":" + mess);
                    pw.flush();
                }
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(user.getId() + "下线了");
        }
    }
}
