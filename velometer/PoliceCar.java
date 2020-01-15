package velometer;

public class PoliceCar {
    private int speed;
    public PoliceCar(){}
    public PoliceCar(int speed){
        this.speed = speed;
    }
    public int getSpeed(PoliceCar policeCar){
        return policeCar.speed;
    }
    public void chase(Car car){
        if(car.getSpeed(car)>=this.speed){
            System.out.println("小汽车跑的太快，望尘莫及呀！");
        }else{
            System.out.println("警车可以追击！");
            int time = 100/(this.speed-car.getSpeed(car));
            try{
                Thread.sleep(3000);//编译时异常
            }catch(Exception a){
                a.printStackTrace();
            }
            System.out.println("用了"+time+"秒成功追上了小汽车");
        }
    }
}
