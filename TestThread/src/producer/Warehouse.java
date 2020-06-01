package producer;

import java.util.ArrayList;

public class Warehouse {
//    private Warehouse(){}
//    private Warehouse warehouse = new Warehouse();
//    public Warehouse getWarehouse(){
//        return warehouse;
//    }

    public ArrayList<String> products = new ArrayList<>();


    public synchronized void add(){
        if(products.size()<20) {
            products.add("宝藏男孩");
            System.out.println("生产一个宝藏男孩");
        }else{
            try {
                this.notifyAll();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void get() {
        if(products.size()>0) {
            String product = products.remove(0);
            System.out.println("取走一个"+product);
        }else{
            //return;
            try {
                this.notifyAll();
                this.wait();//仓库对象调用 wait() 访问仓库的消费者线程进入等待状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
