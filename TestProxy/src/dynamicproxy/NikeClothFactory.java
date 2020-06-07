package dynamicproxy;

//接口
interface ClothFactory {
    void productCloth();
}

//被代理类
public class NikeClothFactory implements ClothFactory{
    @Override
    public void productCloth() {
        System.out.println("Nike工厂生产服装~~");
    }
}