package dynamicproxy;

//接口
interface Human{
    void getBelief();

    void eat(String food);
}

//被代理类
public class SuperMan implements Human{
    public void getBelief(){
        System.out.println("I believe i can fly!");
    }
    public void eat(String food){
        System.out.println("超人喜欢吃"+food);
    }
}
