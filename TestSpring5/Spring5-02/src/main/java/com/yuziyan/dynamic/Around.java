package com.yuziyan.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Around implements MethodInterceptor {
    /**
     *
     * @param invocation 封装了原始方法 invocation.proceed()表示原始方法的运行
     * @return 原始方法的返回值
     * @throws Throwable 可能抛出的异常
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("------ 额外功能 log -----");

        Object ret = invocation.proceed();

        return ret;
    }
}
