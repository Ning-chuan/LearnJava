package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口的方式创建线程
 * 1.实现Callable类
 * 2.重写call方法
 * 3.创建Callable实现类的实例
 * 4.创建一个FutureTask类的对象 用于包装上面的实例
 * 5.创建一个Thread 上面FutureTask的对象作为target 并调用start()方法
 * 6.可以通过FutureTask对象的get()方法获取 call()方法的返回值
 */
class MyCallableThread implements Callable {
    private int num = 0;
    @Override
    public Object call() throws Exception {
        for (int i = 1; i <= 10; i++) {
            num += i;
        }
        return num;
    }
}
public class CallableThreadDemo {
    public static void main(String[] args) {
        /*
        //例1：
        MyCallableThread m1 = new MyCallableThread();
        FutureTask futureTask = new FutureTask(m1);
        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         */

        //例2：
        //用FutureTask对象包装Callable对象call()方法的返回值
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>) () -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":i=" + i);
            }
            return i;
        });

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":i="+i);
            if(i == 20){
                new Thread(task,"有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值："+task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

