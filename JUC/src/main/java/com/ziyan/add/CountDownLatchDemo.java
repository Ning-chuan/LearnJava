package com.ziyan.add;

import java.util.concurrent.CountDownLatch;

/**
 * 原理：
 * 每次有线程调用 countDown() 数量-1，直到计数器变为0时
 * countDownLatch.await() 就会被唤醒，继续向下执行！
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数为6
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go!");
                countDownLatch.countDown();//数量-1
            },String.valueOf(i)).start();
        }

        countDownLatch.await();//等待计数器变为0时 再向下执行

        System.out.println("End!");
    }
}

