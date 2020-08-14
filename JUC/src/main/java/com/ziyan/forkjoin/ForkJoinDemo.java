package com.ziyan.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo extends RecursiveTask<Long> {


    private Long start;
    private Long end;
    private Long limit = 10000L;

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        if (end - start < limit) {
            long sum = 0;
            for (long i = start; i <= end;  i++) {
                sum += i;
            }
            return sum;
        } else {
            long mid = (start + end) / 2;//中间值
            ForkJoinDemo forkTask1 = new ForkJoinDemo(start, mid);
            forkTask1.fork();//拆分任务，把任务压入线程队列
            ForkJoinDemo forkTask2 = new ForkJoinDemo(mid+1, end);
            forkTask2.fork();//拆分任务，把任务压入线程队列
            return forkTask1.join() + forkTask2.join();
        }
    }
}
