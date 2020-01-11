package include;

public class Test {
    public static void main(String[] args){
        Car c = new Car("玛莎拉蒂","曜石黑",
                new Wheel("正新",20));
        c.showCar();
        c.going();
    }
}
