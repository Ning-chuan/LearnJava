package com.ziyan.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile不保证原子性
 * 想保证原子性，需要使用Atomic原子类，这些类的底层都直接和操作系统有关，在内存中修改
 */
public class JMMDemo2 {

    //volatile不保证原子性
    //private volatile static int num = 0;
    //使用原子类 Integer
    private static AtomicInteger num = new AtomicInteger();

    public static void add() {
        //num++;
        num.getAndIncrement();// +1 可以保证操作的原子性
    }

    public static void main(String[] args) {


        //创建20个线程，每个加1000，加完后理论上num的值为20000
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }

        while(Thread.activeCount() > 2){ //main gc
            Thread.yield();//让步
        }

        //查看num结果
        System.out.println(Thread.currentThread().getName()+"=>num="+num);

    }

}
