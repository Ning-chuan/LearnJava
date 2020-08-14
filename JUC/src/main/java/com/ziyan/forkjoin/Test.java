package com.ziyan.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) {
        //test1();//386
        //test2();//255
        test3();//217

    }

    //普通程序员
    public static void test1() {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (long i = 1; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+",时间："+(end - start));
    }

    //会用ForkJoin
    public static void test2() {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0, 10_0000_0000);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = null;
        try {
            sum = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+",时间："+(end - start));
    }

    //Stream并行流计算
    public static void test3(){
        long start = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+",时间："+(end - start));
    }
}
