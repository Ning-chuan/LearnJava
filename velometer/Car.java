package velometer;

public class Car {
    private int speed;
    public Car(){}
    public Car(int speed){
        this.speed = speed;
    }
    public int getSpeed(Car car){
        return car.speed;
    }
}
