package glory_of_kings;

public class TestMain {
    public static void main(String[] args) {
        Hero r1 = new Hero("大小姐");
        Hero r2 = new Hero("上官婉儿");
        Hero r3 = new Hero("孙策");

        //若实现的是Runnable接口 则需要创建Thread将目标对象包起来 然后调用start()
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();



//        r1.start();//Thread类继承的方法
//        r2.start();
//        r3.start();
    }
}
