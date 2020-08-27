package com.ziyan.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Demo02 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        new Thread(()-> phone.sms(),"A").start();

        new Thread(()-> phone.sms(),"B").start();
    }
}
class Phone2{

    ReentrantLock reentrantLock = new ReentrantLock();

    public void sms(){
        //加锁
        reentrantLock.lock();
        reentrantLock.lock();//如果加了两次锁，那么解锁也必须解两次，否则会阻塞
        try {
            System.out.println(Thread.currentThread().getName()+"sms()");
            call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            reentrantLock.unlock();
            reentrantLock.unlock();
        }

    }

    public void call(){
        //加锁
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"call()");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            reentrantLock.unlock();
        }

    }
}
