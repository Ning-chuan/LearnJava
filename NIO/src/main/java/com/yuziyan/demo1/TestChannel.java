package com.yuziyan.demo1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {

    //利用通道完成文件的复制(非直接缓冲区)
    @Test
    public void test1() throws Exception {

        long begin = System.currentTimeMillis();

        //1.获取文件流
        FileInputStream fis = new FileInputStream("D:\\Test\\1.mp4");
        FileOutputStream fos = new FileOutputStream("D:\\Test\\2.mp4");

        //2.获取通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        //3.获取缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //4.读取并写出
        while (inChannel.read(buffer) != -1) {
            //切换模式
            buffer.flip();
            //把缓冲区中的数据写出去
            outChannel.write(buffer);
            //清空缓冲区
            buffer.clear();
        }
        //5.关闭资源
        outChannel.close();
        inChannel.close();
        fos.close();
        fis.close();

        long end = System.currentTimeMillis();
        System.out.println("非直接缓冲区的方式耗时：" + (end - begin));//3767
    }

    //使用直接缓冲区完成文件的复制（内存映射文件）
    @Test
    public void test2() throws IOException {

        long begin = System.currentTimeMillis();

        //1.获取管道
        FileChannel inChannel = FileChannel.open(Paths.get("D:/Test/1.mp4"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("D:/Test/2.mp4"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        //2.获取内存映射文件缓冲区
        MappedByteBuffer inBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //3.直接对缓冲区进行读写
        byte[] dst = new byte[inBuffer.limit()];
        inBuffer.get(dst);
        outBuffer.put(dst);

        outChannel.close();
        inChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("直接缓冲区的方式耗时：" + (end - begin));//721  注意：多次连续执行，可能会出现时间为 2365的情况

    }


    //通道之间直接传输数据
    @Test
    public void test3() throws IOException {

        long begin = System.currentTimeMillis();

        //1.获取管道
        FileChannel inChannel = FileChannel.open(Paths.get("D:/Test/1.mp4"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("D:/Test/2.mp4"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //2.直接传输：
        //inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel, 0, inChannel.size());

        //3.关闭资源
        outChannel.close();
        inChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("通道之间直接传输数据耗时：" + (end - begin));//1863
    }

}
