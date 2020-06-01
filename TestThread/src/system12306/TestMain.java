package system12306;

public class TestMain {
    public static void main(String[] args){
        System12306 system12306 = System12306.getInstance();
        Window w1 = new Window("宜川北站");
        Window w2 = new Window("西街客运站");
        Window w3 = new Window("东关店客运站");
        w1.start();
        w2.start();
        w3.start();
    }
}
