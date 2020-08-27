package com.ziyan.lock;

import sun.font.PhysicalFont;

import java.util.concurrent.TimeUnit;

public class Demo01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sms();
        },"A").start();

        new Thread(()->{
            phone.sms();
        },"B").start();
    }
}
class Phone{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+"sms()");
        call();//调用自己带锁的方法
    }

    private synchronized void call() {
        System.out.println(Thread.currentThread().getName()+"call()");
    }
}
