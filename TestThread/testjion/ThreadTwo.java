package testjion;

public class ThreadTwo extends Thread{
    public void run(){
        System.out.println("ThreadTwo start");


        ThreadThree three = new ThreadThree(this);
        three.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("ThreadTwo end");
    }
}
