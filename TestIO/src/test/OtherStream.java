package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 其他流的使用：
 * 1.标准输入、输出流
 * 2.打印流
 * 3.数据流
 */
public class OtherStream {
    public static void main(String[] args) {
        /*
        1.标准的输入、输出流
        1.1
        System.in:标准的输入流，默认从键盘输入
        System.out:标准的输出流，默认从控制台输出
        1.2
        System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的流。

        1.3练习：
        从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，
        直至当输入“e”或者“exit”时，退出程序。

        方法一：使用Scanner实现，调用next()返回一个字符串
        方法二：使用System.in实现。System.in  --->  转换流 ---> BufferedReader的readLine()
        */


        BufferedReader br = null;//有读取一行的方法 所以用这个
        try {
            //1.获取用户输入
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while(true){
                System.out.println("请输入要变为大写的字符串：");
                String value = br.readLine();
                if("e".equals(value) || "exit".equals(value)){
                    System.out.println("程序退出");
                    break;
                }
                System.out.println(value.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流管道
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
