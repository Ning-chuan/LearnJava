package copy;

import java.io.*;

public class BufferedInputAndOutput {
    public static void main(String[] args) {
        String src = "C:\\Users\\Administrator\\Desktop//ideaIU-2020.1.exe";
        String dest = "C:\\Users\\Administrator\\Desktop//blibliu.exe";

        long start = System.currentTimeMillis();
        copy(src,dest);
        long end = System.currentTimeMillis();

        System.out.println("复制文件用时："+(end - start));//1913毫秒

    }
    public static void copy(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.创建Buffered字节型输入输出流
            bis = new BufferedInputStream(new FileInputStream(new File(srcPath)));
            bos = new BufferedOutputStream(new FileOutputStream(new File(destPath)));
            //2.读写文件
            byte[] car = new byte[1024];
            int len;
            while((len =bis.read(car)) != -1){
                //写出去
                bos.write(car,0,len);
            }
            System.out.println("文件复制完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流 注意关闭高级流的时候会自动关闭其对应的低级流
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
