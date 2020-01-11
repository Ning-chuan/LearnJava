package include;

public class Wheel {
    public int size;
    public String brand;
    public void rotate(){
        System.out.println("轮子开始转动");
    }
    public Wheel(){}
    public Wheel(String brand,int size){
        this.brand = brand;
        this.size = size;
    }
}
