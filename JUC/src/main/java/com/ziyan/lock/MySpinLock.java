package com.ziyan.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自定义自旋锁
 */
public class MySpinLock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //加锁方法
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.currentThread().getName()+"=>myLock");
        //自旋关键循环
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }

    //解锁方法
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"=>myUnLock");
        //解锁操作
        atomicReference.compareAndSet(thread, null);
    }
}
class TestMySpinLock{
    public static void main(String[] args) {
        MySpinLock mySpinLock = new MySpinLock();

        new Thread(()->{
            mySpinLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mySpinLock.myUnLock();
            }
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            mySpinLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mySpinLock.myUnLock();
            }
        },"B").start();

    }
}
