package testjion;

public class ThreadOne extends Thread{


    public void run(){
        System.out.println("ThreadOne start");
        ThreadTwo tt = new ThreadTwo();
        tt.start();
        try {
            tt.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadOne end");
    }
}
