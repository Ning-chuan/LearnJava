package com.yuziyan.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCGlibProxy {
    public static void main(String[] args) {
        //1.创建原始对象
        UserServiceImpl userService = new UserServiceImpl();

        //2.通过CGlib创建代理对象
        //  2.1 创建Enhancer
        Enhancer enhancer = new Enhancer();
        //  2.2 设置借用类加载器
        enhancer.setClassLoader(TestCGlibProxy.class.getClassLoader());
        //  2.3 设置父类（目标类）
        enhancer.setSuperclass(userService.getClass());
        //  2.4 设置回调，额外功能写在里面
        enhancer.setCallback(new MethodInterceptor() {
            //相当于 InvocationHandler --> invoke()
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //额外功能：
                System.out.println("========= CGlibProxy log ========");
                //目标方法执行：
                Object ret = method.invoke(userService, objects);
                return ret;
            }
        });
        //  2.5 通过Enhancer对象创建代理
        UserServiceImpl service = (UserServiceImpl) enhancer.create();

        //测试：
        service.register();
        service.login();

    }
}
