package com.ziyan.pc;

/**
 *
 *   synchronized版 生产者和消费者问题
 */
public class ProducerAndConsumer01 {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
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

class Data{
    //操作量
    private int num = 0;

    //增加方法：
    public synchronized void increment() throws InterruptedException {
        //用if会产生‘虚假唤醒’问题，应该用while
        while(num > 0){
            //num不为零就等待，直到num==0时才增加num
            wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"=>增加完毕，num="+num);
        //通知其他线程
        notifyAll();
    }

    //减少方法：
    public synchronized void decrement() throws InterruptedException {
        while(num <= 0){
            //num==0就等待，直到num不为零时才减少num
            wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"=>减少完毕，num="+num);
        //通知其他线程
        notifyAll();
    }
}
