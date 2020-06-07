package server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 发送消息的线程
 */
public class ServerWriter implements Runnable{

    private Socket socket;
    public ServerWriter(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        OutputStream os = null;
        OutputStreamWriter osw = null;//转换成字符流
        PrintWriter pw = null;//打印流有输出一行的方法 所以用打印流
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("可以给客户端发消息了...");

            //1.获取输出流
            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            pw = new PrintWriter(osw);
            //2.把控制台输入的消息发出去
            while(true) {
                String mess = input.nextLine();
                pw.println(mess);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭资源
            if (pw != null)pw.close();
            try {
                if (osw != null) osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null)os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
