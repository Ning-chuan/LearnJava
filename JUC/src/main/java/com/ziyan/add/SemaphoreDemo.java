package com.ziyan.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore 信号量
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //参数3意义：调用3次acquire()方法且没有被释放时，后面的acquire()会阻塞，直到前面的释放为止
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//获得
                    System.out.println(Thread.currentThread().getName()+"=>获得停车位");

                    TimeUnit.SECONDS.sleep(2);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName()+"=>离开停车位");
                    semaphore.release();//释放
                }
            },String.valueOf(i)).start();
        }
    }
}
