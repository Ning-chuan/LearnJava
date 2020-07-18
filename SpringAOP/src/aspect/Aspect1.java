package aspect;

public class Aspect1 {
    public void before(){
        System.out.println("Aspect1前置方法：");
    }

    public void after(){
        System.out.println("Aspect1最终通知");
    }
}
