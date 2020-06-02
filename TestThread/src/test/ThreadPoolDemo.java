package test;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class NumThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //1.创建固定线程数为6的线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //2.向线程池中提交两个线程
        pool.submit(new NumThread());
        pool.submit(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 2 != 0){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        });
        //3.关闭线程
        pool.shutdown();
    }
}
