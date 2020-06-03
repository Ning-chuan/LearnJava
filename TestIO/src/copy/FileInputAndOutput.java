package copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputAndOutput {
    public static void main(String[] args) {
        String src = "C:\\Users\\Administrator\\Desktop//ideaIU-2020.1.exe";
        String dest = "C:\\Users\\Administrator\\Desktop//alialiu.exe";

        long start = System.currentTimeMillis();
        copy(src,dest);
        long end = System.currentTimeMillis();

        System.out.println("复制文件用时："+(end - start));//4834毫秒

    }
    public static void copy(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1.创建文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.创建输入和输出流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //3.读写文件
            byte[] car = new byte[1024];
            int len;
            while((len = fis.read(car)) != -1){
                //写出去
                fos.write(car,0,len);
            }
            System.out.println("文件复制完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

