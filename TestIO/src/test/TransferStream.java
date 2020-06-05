package test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 *   InputStreamReader：将一个字节的输入流转换为字符的输入流
 *   OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.解码：字节、字节数组  --->字符数组、字符串
 *   编码：字符数组、字符串 ---> 字节、字节数组
 *
 */
public class TransferStream {
    public static void main(String[] args) {
        String src = "dbcp.txt";
        String dest = "dbcp1.txt";
        String srcCharset = "UTF-8";
        String destCharset = "GBK";
    }

    /**
     * 定义方法：实现转码(编码-->解码)功能
     * 描述：把一个文本文件转换为指定编码方式编码的文本文件
     * @param srcPath 源文件路径
     * @param srcCharset 源文件编码集
     * @param destPath 目标路径
     * @param destCharset 目标编码集
     */
    public static void transfer(String srcPath,String srcCharset,String destPath,String destCharset){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //1.创建字节型输入流和输入转换流（输入转换流的作用是将字节流按指定编码方式转为字符输入流）
            FileInputStream fis = new FileInputStream(new File(srcPath));
            isr = new InputStreamReader(fis, srcCharset);
            //2.创建输出转化流和字节型输出流（输出转换流的作用是将字符流按指定编码方式转为字节输出流）
            FileOutputStream fos = new FileOutputStream(new File(destPath));
            osw = new OutputStreamWriter(fos,destCharset);
            //3.进行读写操作
            char[] car = new char[20];
            int len;
            while((len = isr.read(car)) != -1){
                osw.write(car,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.读写完毕，关闭资源（注意关闭转换流对应的流也会关闭）
            if(osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
