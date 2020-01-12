package velometer;

public class SpeedMeter {
    private int standardTime = 5;
    public void speedmeter(Car car){
        int carSpeed = car.getSpeed(car);
        int time = 100/carSpeed;
        if(time<standardTime){
            System.out.println("小汽车不听话，警车可以开始追击了");
            PoliceCar pc = new PoliceCar(25);
            pc.chase(car);
        }else{
            System.out.println("车速正常，祝您一路平安。");
        }
    }
}
