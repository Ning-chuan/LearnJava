package com.ziyan.volatiletest;

import java.util.concurrent.TimeUnit;

public class JMMDemo {

    //加volatile关键字时，工作线程对主线程的操作可见
    //不加volatile，工作线程对主线程的操作不知情，会变成死循环
    private volatile static int num = 1;

    public static void main(String[] args) {
        new Thread(()->{
            //循环的目的：看工作线程能否知道主线程的操作
            while(num != 0){

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 0;
        System.out.println("num="+num);
    }
}
