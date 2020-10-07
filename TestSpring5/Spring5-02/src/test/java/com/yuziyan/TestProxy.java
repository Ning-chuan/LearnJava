package com.yuziyan;

import com.yuziyan.factory.UserService;
import com.yuziyan.proxy.User;
import org.junit.Test;
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
}
