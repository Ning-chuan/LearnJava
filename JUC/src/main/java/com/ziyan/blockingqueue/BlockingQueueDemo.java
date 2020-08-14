package com.ziyan.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        //test1();
        //test2();
//        try {
//            test3();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            test4();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 有返回值，抛出异常
     */
    public static void test1(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        //如果正常添加 会返回布尔值 true/false
        System.out.println(arrayBlockingQueue.add('a'));
        System.out.println(arrayBlockingQueue.add('b'));
        System.out.println(arrayBlockingQueue.add('c'));

        //队列满时，会抛出异常IllegalStateException: Queue full
        //System.out.println(arrayBlockingQueue.add('d'));

        //正常删除 会返回删除的元素
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());

        //队列空时，会抛出异常NoSuchElementException
        //System.out.println(arrayBlockingQueue.remove());
    }

    public static void test2(){
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        //如果正常添加 会返回布尔值 true/false
        System.out.println(arrayBlockingQueue.offer('a'));
        System.out.println(arrayBlockingQueue.offer('b'));
        System.out.println(arrayBlockingQueue.offer('c'));

        //队列满时再添加会返回false，但是不抛异常
        System.out.println(arrayBlockingQueue.offer('d'));

        //正常删除 会返回删除的元素
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());

        //队列空时再移除，会返回null，但是不抛异常
        System.out.println(arrayBlockingQueue.poll());
    }

    /**
     * 如果队列满还添加或者队列空了还获取，就会一直阻塞
     * @throws InterruptedException
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

        arrayBlockingQueue.put('a');
        arrayBlockingQueue.put('b');
        arrayBlockingQueue.put('c');

        //队列满时再添加会一直阻塞
        //arrayBlockingQueue.put('d');

        //正常删除 会返回删除的元素
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        //System.out.println(arrayBlockingQueue.take());//没有元素的时候，一直阻塞
    }


    public static void test4() throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);

        arrayBlockingQueue.offer('a');
        arrayBlockingQueue.offer('b');
        arrayBlockingQueue.offer('c');

        //队列满时再添加会阻塞2秒 然后退出
        arrayBlockingQueue.offer('d',2, TimeUnit.SECONDS);

        //正常删除 会返回删除的元素
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        //没有元素的时候，只会阻塞2秒
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));
    }



}
