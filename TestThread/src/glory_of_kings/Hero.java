package glory_of_kings;

public class Hero implements Runnable{
    private String name;
    public Hero(){}
    public Hero(String name){
        this.name = name;
    }
    public void run() {
        for (int i=1;i<100;i++) {
            System.out.println(this.name+"正在补第"+i+"个兵");
        }
    }

}
