package practice;

/**
 * 例题描述：使用两个线程打印1-100，要求两个线程交替打印
 * wait()和notify()必须在synchronized中调用
 */
public class AlternatePrint {
    public static void main(String[] args) {
        Print p = new Print();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        t1.start();
        t2.start();
    }
}
class Print implements Runnable{
    private int num = 0;

    @Override
    public void run() {

        while(num <= 100){
            synchronized (this) {
                //1.唤醒另一个线程
                notify();
                //2.执行打印操作
                System.out.println(Thread.currentThread().getName()+":"+num);
                num++;
                //3.挂起当前线程 注意挂起当前线程之后会释放锁
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
