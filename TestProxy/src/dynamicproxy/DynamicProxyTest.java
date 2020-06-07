package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        Human proxyInstance1 = (Human) ProxyFactory.getProxyInstance(new SuperMan());
        proxyInstance1.getBelief();
        proxyInstance1.eat("水煮小鹿");
        System.out.println("======================================");

        NetWork proxyInstance2 = (NetWork)ProxyFactory.getProxyInstance(new Server());
        proxyInstance2.browse();
        System.out.println("======================================");


        ClothFactory proxyInstance3 = (ClothFactory) ProxyFactory.getProxyInstance(new NikeClothFactory());
        proxyInstance3.productCloth();
        System.out.println("======================================");

    }
}

//动态代理工厂 可以动态生产代理类
class ProxyFactory{
    /**
     * 获取代理类的静态方法
     * @param obj 被代理类对象作为参数
     * @return 返回一个代理类对象
     */
    public static Object getProxyInstance(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理类做准备工作");
                Object result =  method.invoke(obj,args);
                System.out.println("代理类做收尾工作");
                return result;
            }
        });
    }
}