package producer;

public class Consumer extends Thread{
    private Warehouse warehouse;
    public Consumer(Warehouse warehouse){
        this.warehouse = warehouse;
    }


    public void run(){
        while(true) {
            warehouse.get();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
