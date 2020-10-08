package com.yuziyan.aspect;

import com.yuziyan.proxy.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserServiceImpl implements UserService, ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");

        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("蒙恬", "8888");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login");
        return true;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
