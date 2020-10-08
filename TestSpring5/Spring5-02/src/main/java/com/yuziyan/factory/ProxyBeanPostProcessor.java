package com.yuziyan.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 问题：为什么通过id获得的是代理对象？
 * 这个类模拟Spring框架创建代理对象的方式
 */
public class ProxyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        InvocationHandler invocation = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("----------- 模拟Spring返回代理对象的方式 log -----------");

                Object ret = method.invoke(bean, args);

                return ret;
            }
        };

        return Proxy.newProxyInstance(ProxyBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), invocation);
    }
}
