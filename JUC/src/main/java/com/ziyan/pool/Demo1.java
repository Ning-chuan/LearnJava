package com.ziyan.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) {
        //1.自定义线程池
        //最大线程数实际工作中怎么定义（两种策略）：
        //CPU密集型：几核就设置几，可以保证CPU效率最高
        //IO密集型：判断程序中耗IO的线程

        //获取核心数：
        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,//核心线程
                Runtime.getRuntime().availableProcessors(),//最大线程数 设置为和处理器核心数一致
                3, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),//阻塞队列
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());//队列满了 和最早的竞争，不抛异常

        try {
            //最大承载：Deque + max
            for (int i = 1; i <= 9; i++) {
                //2.使用线程池创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"=>ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3.用完线程池 将其关闭
            threadPool.shutdown();
        }

    }
}
