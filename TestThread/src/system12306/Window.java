package system12306;

public class Window extends Thread {
    private String name;
    public Window(){}
    public Window(String name){
        this.name = name;
    }

    public void run(){
        this.sellTickets();
    }

    public void sellTickets(){
        System12306 s = System12306.getInstance();
        while(true) {
            if (s.tickets.size() != 0) {
                Ticket t = s.tickets.remove(0);
                System.out.println(this.name + "卖出一张" + t.getStart() + "到" + t.getEnd() + "编号为" + t.getNum() + "票价为" + t.getPrice() + "的票");
            } else {
                System.out.println(this.name + "车票已售完");
                break;
            }
        }
    }
}
