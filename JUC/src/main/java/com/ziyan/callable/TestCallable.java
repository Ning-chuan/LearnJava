package com.ziyan.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //用Callable启动线程
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask(myThread);
        //FutureTask是Runnable的实现类 可以传入Thread的构造器
        new Thread(futureTask,"A").start();
        //如果是同一个FutureTask对象，结果会被缓存，即Callable对象的call()只执行一次
        new Thread(futureTask,"B").start();
        new Thread(futureTask,"C").start();
        //但如果是不同的FutureTask对象 call()会新执行一次
        FutureTask futureTask1 = new FutureTask(myThread);
        new Thread(futureTask1, "D").start();

        //通过FutureTask对象的get()方法获取Callable对象call()方法的返回值
        int res = (Integer)futureTask.get();//get方法可能会长生阻塞 要放到最后
        System.out.println(res);

        int res1 = (Integer)futureTask1.get();//get方法可能会长生阻塞 要放到最后
        System.out.println(res1);

    }
}

class MyThread implements Callable<Integer> {

    //Callable<Integer>泛型规定的是下面方法的返回值类型
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"=>call()执行了");//
        return 1024;
    }
}
