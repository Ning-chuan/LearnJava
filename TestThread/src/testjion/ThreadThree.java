package testjion;

public class ThreadThree extends Thread{
    private ThreadTwo two;
    public ThreadThree(ThreadTwo two){
        this.two = two;
    }


    public void run(){
        System.out.println("ThreadThree start");
        synchronized(two){
            System.out.println("ThreadTwo is locked");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadTwo is free");
        }
        System.out.println("ThreadThree end");
    }
}
