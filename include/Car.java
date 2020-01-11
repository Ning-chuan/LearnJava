package include;

public class Car {
    public String brand;
    public String color;
    public Wheel carWheel;
    public Car(){}
    public Car(String brand,String color,Wheel carWheel){
        this.brand = brand;
        this.color = color;
        this.carWheel = carWheel;
    }
    public void showCar(){
        System.out.println("汽车颜色："+this.color+" 汽车品牌："+this.brand
    +" 轮胎品牌："+this.carWheel.brand+" 轮胎尺寸："+this.carWheel.size);
    }
    public void going(){
        carWheel.rotate();
        System.out.println("一辆"+this.color+"的"+this.brand+"开始行驶了");
    }

}
