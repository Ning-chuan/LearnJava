package test;

/**
 * 用实现Runnable接口的方式创建线程 步骤如下：
 * 1.自定义一个类 实现Runnable接口
 * 2.重写run()方法
 * 3.创建一个该类的实例
 * 4.创建一个Thread实例 把上面自定义类的实例作为参数传给Thread的构造器
 * 5.调用这个Thread实例的start()方法
 */
public class TestThread {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        t1.setName("线程一");
        t2.setName("线程二");
        //t1.setPriority(Thread.MAX_PRIORITY);//设置优先级
        t1.start();
        t2.start();
    }
}
class MyThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

