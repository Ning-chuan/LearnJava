package producer;

public class Producer extends Thread{
    private Warehouse warehouse;
    public Producer(Warehouse warehouse){
        this.warehouse = warehouse;
    }

    public void run(){
        while(true) {
            warehouse.add();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
