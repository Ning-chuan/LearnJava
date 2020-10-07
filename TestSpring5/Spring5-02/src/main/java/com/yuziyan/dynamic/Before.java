package com.yuziyan.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Before implements MethodBeforeAdvice {
    /**
     * 作用：给原始方法添加额外功能
     * 注意：会在原始方法运行之前运行此方法
     * @param method 原始方法 login() register() ...
     * @param objects 原始方法的参数列表 name password ...
     * @param o 原始对象 UserServiceImpl OrderServiceImpl
     * @throws Throwable 抛出的异常
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("---- MethodBeforeAdvice  log... ----");
    }
}
