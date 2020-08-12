package com.ziyan.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现：A执行完调用B，B执行完调用C，C执行完调用A
 */
public class ProducerAndConsumer03 {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printA();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printC();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print.printB();
            }
        }, "B").start();
    }
}

class Print {
    //操作数据
    private int num = 1;

    //为了实现功能创建的锁
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    //打印A
    public void printA() {
        lock.lock();
        try {
            while (num != 1) {
                //如果num不是1 就不打印A 让condition1等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>AAAAAAAA");
            num = 2;
            //通知打印B
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //打印B
    public void printB() {
        lock.lock();
        try {
            while (num != 2) {
                //如果num不是2 就不打印B 让condition2等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>BBBBBBBB");
            num = 3;
            //通知打印C
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //打印B
    public void printC() {
        lock.lock();
        try {
            while (num != 3) {
                //如果num不是3 就不打印C 让condition3等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>CCCCCCCC");
            num = 1;
            //通知打印A
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
