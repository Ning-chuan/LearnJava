package com.ziyan.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        //调用7次 CyclicBarrier对象await()方法后执行第二个参数的执行体
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, ()-> System.out.println("龙珠收集完毕，召唤神龙"));

        for (int i = 1; i <= 7; i++) {
            //因为后面的lambda表达式用到了temp 所以temp必须时final变量
            //如果不专门声明，jdk会默认加上final关键字
            int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"=>收集了"+temp+"个龙珠");

                try {
                    cyclicBarrier.await();//等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
