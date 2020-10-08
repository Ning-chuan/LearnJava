package com.yuziyan;

import com.yuziyan.factory.UserService;
import com.yuziyan.proxy.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProxy {

    /**
     * 用于测试：MethodBeforeAdvice
     */
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userServiceImpl");
        System.out.println("userService = " + userService);

        userService.register(new User());
        userService.login("小强", "123456");
    }
    
    /**
     * 用于测试：模拟Spring返回代理对象的方式
     */
    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext1.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.register(new User("鲁智深","3333"));
        userService.login("小花花","5555");

    }

    /**
     * 用于测试：基于注解的aop编程
     */
    @Test
    public void test3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        com.yuziyan.aspect.UserService userService = (com.yuziyan.aspect.UserService) ctx.getBean("userService");
        userService.register(new User("鲁智深","3333"));
        //userService.login("小花花","5555");

    }
}
