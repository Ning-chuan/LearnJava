package com.ziyan.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutors {
    public static void main(String[] args) {
        //1.创建线程池 三大方法：
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//池中只有一个线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//池中有固定数量个线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//池中线程数量可根据需求变化


        try {
            for (int i = 0; i < 1000; i++) {
                //2.使用线程池创建线程
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3.使用完毕，关闭线程池
            threadPool.shutdown();
        }
    }
}
