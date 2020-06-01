package producer;

public class TestMain {
    public static void main(String[] args){
        Warehouse warehouse = new Warehouse();
        Producer p = new Producer(warehouse);
        //设置线程优先级别 1-10
        //p.setPriority(10);

        Consumer c1 = new Consumer(warehouse);
        Consumer c2 = new Consumer(warehouse);
        p.start();
        c1.start();
        c2.start();
    }
}
