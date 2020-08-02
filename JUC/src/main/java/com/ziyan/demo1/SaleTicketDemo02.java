package com.ziyan.demo1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock锁
 */
public class SaleTicketDemo02 {
    public static void main(String[] args) {
        Ticket1 ticket = new Ticket1();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) ticket.sale();
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) ticket.sale();
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) ticket.sale();
        }, "C").start();
    }
}

class Ticket1 {
    private int number = 120;

    ReentrantLock lock = new ReentrantLock();

    public void sale() {
        //1.加锁
        lock.lock();
        try {
            //2.业务代码
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + (number--) + "票，剩余：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //3.解锁
            lock.unlock();
        }
    }
}
