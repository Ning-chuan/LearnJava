package practice;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目描述：有两个人分别给同一个银行账户存3000元，每次存1000，总共存三次。每次存完打印银行账户。
 * 注意：此题会出现线程安全问题 原因如下：
 * 1.多个线程 （两个人）
 * 2.操作同一个数据 （account）
 */
public class AccountTest {
    public static void main(String[] args) {
        User user = new User(new Account(0));

        Thread t1 = new Thread(user);
        Thread t2 = new Thread(user);
        t1.start();
        t2.start();
    }
}

class Account{
    public double balance;
    public Account(double balance){
        this.balance = balance;
    }
}
class User implements Runnable {
    private Account account;
    public User(Account account){
        this.account = account;
    }

    private ReentrantLock rt = new ReentrantLock();//为方式三准备的属性

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            //方式一：同步代码块
//            synchronized (this) {
//                System.out.println(Thread.currentThread().getName() + "存款前余额：" + account);
//                account += 1000;
//                System.out.println(Thread.currentThread().getName() + "存款后余额:" + account);
//            }
            //方式二：同步方法
            //save();

            //方式三
            //ReentrantLock rt = new ReentrantLock();//不应该在此处定义锁 而应该定义在属性里 要保证锁是同一个
            rt.lock();//手动打开
            save();
            rt.unlock();//手动关闭

            //此处的 try catch 只是为了让结果更明显
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private synchronized void safeSave () {//方式二方法
        System.out.println(Thread.currentThread().getName() + "存款前余额：" + account.balance);
        account.balance += 1000;
        System.out.println(Thread.currentThread().getName() + "存款后余额:" + account.balance);
    }
    private void save() {//方式三方法
        System.out.println(Thread.currentThread().getName() + "存款前余额：" + account.balance);
        account.balance += 1000;
        System.out.println(Thread.currentThread().getName() + "存款后余额:" + account.balance);
    }

}


