package system12306;

import java.util.Vector;

public class System12306 {
    //单例模式 系统只能有一个
    private static System12306 system12306 = new System12306();
    private System12306(){}
    public static System12306 getInstance(){
        return system12306;
    }


    public Vector<Ticket> tickets = new Vector<>();
    {
        for(int i=1;i<=100;i++){
            tickets.add(new Ticket("宜川","西安",i,i%5+100));
        }
    }
}
