package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class QQFrame extends JFrame {

    //面板
    private JPanel panel = new JPanel();

    //组件
    //展示消息文本域
    private JTextArea messArea = new JTextArea();
    //展示消息文本域的滚动条
    private JScrollPane messPane = new JScrollPane(messArea);
    //发送消息文本域和他的滚动条
    private JTextArea speakArea = new JTextArea();
    private JScrollPane speakPane = new JScrollPane(speakArea);
    //发送和取消按钮
    private JButton sendButton = new JButton("发送");
    private JButton cancelButton = new JButton("取消");

    Socket socket;

    public QQFrame(String name) {
        super(name);
        this.initSelf();
        this.initLayout();
        this.addElements();
        this.addListener();

        //布局完成，和服务器建立一个连接
        try {
            socket = new Socket("localhost", 9966);
            //告知服务器自己的id
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println(name);
            pw.flush();

            //只创建读线程（写线程点击发送按钮时才创建）
            Thread reader = new Thread(new ClientReader());
            reader.start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private void initLayout() {
        //清空默认管理布局
        panel.setLayout(null);
        messPane.setBounds(20, 10, 540, 300);
        speakPane.setBounds(20, 340, 540, 250);
        sendButton.setBounds(380, 600, 80, 30);
        cancelButton.setBounds(480, 600, 80, 30);

        //设置展示文本域不可更改
        //messArea.setFocusable(false);
        messArea.setEditable(false);
    }

    private void addElements() {
        //将组件添加到面板
        panel.add(messPane);
        panel.add(speakPane);
        panel.add(sendButton);
        panel.add(cancelButton);
        //将面板添加到窗体
        this.add(panel);
    }

    private void initSelf() {
        //设置点击×号程序结束
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置窗体大小、位置
        this.setBounds(650, 150, 600, 700);
        //设置可见
        this.setVisible(true);
    }

    private void addListener() {
        sendButton.addActionListener((e) -> {
            try {
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                pw.println(speakArea.getText());
                pw.flush();
                //清空输入框
                speakArea.setText("");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speakArea.setText("");
            }
        });
    }

    //内部类 读取消息的线程
    public class ClientReader implements Runnable {

        private StringBuilder builder = new StringBuilder();

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
                    builder.append(resp+"\n");
                    messArea.setText(builder.toString());
                    //System.out.println(resp);
                }
            } catch (IOException e) {
                //e.printStackTrace();
                System.out.println("服务器下线了");
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

    public static void main(String[] args) {
        new QQFrame("于自言");
        new QQFrame("百晓生");
        new QQFrame("杨玉环");
    }

}
