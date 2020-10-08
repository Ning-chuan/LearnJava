package com.yuziyan.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 声明切面类     @Aspect
 * 定义额外功能   @Around
 * 定义切入点     @Around("execution(* login(..))")
 *
 */
@Aspect
public class MyAspect {

    /**
     * 切入点复用：定义一个函数，加上@Pointcut注解，通过该注解的value定义切入点表达式，以后可以复用。
     */
    @Pointcut("execution(* *..UserServiceImpl.*(..))")
    public void myPointcut(){}

    @Around("myPointcut()")//组装了切入点和额外功能
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //额外功能：
        System.out.println("--------- 基于注解的AOP编程 log --------");
        //原始方法执行：
        Object ret = joinPoint.proceed();

        return ret;
    }


    @Around("myPointcut()")
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        //额外功能：
        System.out.println("--------- 基于注解的AOP编程 tx --------");
        //原始方法执行：
        Object ret = joinPoint.proceed();

        return ret;
    }

}
