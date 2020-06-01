package philosopher;

public class TestMain {
    public static void main(String[] args){
        Chopstick c1 = new Chopstick(1);
        Chopstick c2 = new Chopstick(2);
        Chopstick c3 = new Chopstick(3);
        Chopstick c4 = new Chopstick(4);
        Philosopher p1 = new Philosopher("王晨曦",c2,c1,0L);
        Philosopher p2 = new Philosopher("陈浩然",c3,c2,2000L);
        Philosopher p3 = new Philosopher("崔林森",c4,c3,0L);
        Philosopher p4 = new Philosopher("苟犇",c1,c4,2000L);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }
}
