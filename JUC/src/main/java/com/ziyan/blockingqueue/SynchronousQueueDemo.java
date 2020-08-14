package com.ziyan.blockingqueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        /**
         * 同步队列，只能存储一个元素
         * 如果已经put一个元素了，则必须等待take出来，才能再put元素
         */
        SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"=>put 1");
                synchronousQueue.put('1');

                System.out.println(Thread.currentThread().getName()+"=>put 2");
                synchronousQueue.put('2');

                System.out.println(Thread.currentThread().getName()+"=>put 3");
                synchronousQueue.put('3');
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"=>take "+synchronousQueue.take());

                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"=>take "+synchronousQueue.take());
                
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"=>take "+synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }
}
