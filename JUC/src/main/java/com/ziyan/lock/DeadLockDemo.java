package com.ziyan.lock;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lock1";
        String lockB = "lock2";
        new Thread(new MyThread(lockA,lockB)).start();
        new Thread(new MyThread(lockB,lockA)).start();
    }
}
class MyThread implements Runnable{

    String lockA;
    String lockB;

    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized(lockA){
            System.out.println(Thread.currentThread().getName()+"锁定了"+lockA+"，试图获取"+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(lockB){
                System.out.println(Thread.currentThread().getName()+"锁定了"+lockB);
            }
        }
    }
}
