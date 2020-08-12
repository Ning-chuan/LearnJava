package com.ziyan.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *   JUC版 生产者和消费者问题
 */
public class ProducerAndConsumer02 {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"add1").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"reduce1").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"reduce2").start();
    }
}

class Data2{
    //操作量
    private int num = 0;

    //锁
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    //增加方法：
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            //用if会产生’虚假唤醒‘问题，应该用while
            while(num > 0){
                //num不为零就等待，直到num==0时才增加num
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"=>增加完毕，num="+num);
            //通知其他线程
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    //减少方法：
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while(num <= 0){
                //num==0就等待，直到num不为零时才减少num
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"=>减少完毕，num="+num);
            //通知其他线程
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }

    }
}

