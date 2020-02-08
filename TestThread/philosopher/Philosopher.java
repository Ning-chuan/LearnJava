package philosopher;

public class Philosopher extends Thread{
    private String name;
    private Chopstick left;
    private Chopstick right;
    private Long time;

    public Philosopher(String name,Chopstick left,Chopstick right,Long time){
        this.name = name;
        this.left = left;
        this.right = right;
        this.time = time;

    }

    public void run(){
        try {
            Thread.sleep(this.time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized(left){
            System.out.println(this.name+"拿起了左手边的筷子");
            synchronized(right){
                System.out.println(this.name+"拿起了右手边的筷子狼吞虎咽的吃了起来");
            }
        }
    }

}
