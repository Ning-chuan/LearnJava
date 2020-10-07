package com.yuziyan.jdk;

import com.yuziyan.factory.UserService;
import com.yuziyan.factory.UserServiceImpl;
import com.yuziyan.proxy.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 测试JDK动态代理
 */
public class TestJDKProxy {
    public static void main(String[] args) {
        //1.创建原始对象
        //注意：由于后面匿名子类的方法中用到了userService，所以应该用final修饰
        //     而JDK1.8以后默认加了final，不需要手动加
        UserService userService = new UserServiceImpl();

        //2.JDK创建代理对象
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("----------- JDKProxy log -----------");
                //目标方法运行：
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };

        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(),handler);

        userServiceProxy.login("海绵宝宝", "1111");
        userServiceProxy.register(new User());

    }
}
