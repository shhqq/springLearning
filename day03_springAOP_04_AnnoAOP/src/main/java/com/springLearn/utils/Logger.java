package com.springLearn.utils;

/**
 * Created by s on 2020/6/9 17:07.
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 * 改为使用annotation的AOP
 */

@Component("logger")    //
@Aspect                 // 表示这是一个切面类
public class Logger {
    /**
     * 配置切入点表达式
     */
    @Pointcut("execution(* com.springLearn.service.impl.*.*(..))")
    private void pt(){};

    /**
     * 用于打印日志，计划让其在切入点方法执行前执行（切入点方法就是业务层方法）
     * 前置通知
     */
//    @Before("pt()")
    public void beforePrintLog(){
        System.out.println("Logger类中的printLog方法开始记录日志--前置通知");
    }

    /**
     * 后置通知
     */
//    @AfterReturning("pt()")
    public void afterReturningPrintLog(){
        System.out.println("Logger类中的printLog方法开始记录日志--后置通知");
    }

    /**
     * 异常通知
     */
//    @AfterThrowing("pt()")
    public void afterThrowingPrintLog(){
        System.out.println("Logger类中的printLog方法开始记录日志--异常通知");

    }

    /**
     * 最终通知
     */
//    @After("pt()")
    public void afterPrintLog(){
        System.out.println("Logger类中的printLog方法开始记录日志--最终通知");

    }

    /**
     * 环绕通知
     *  问题：
     *      当配置环绕通知时，切入点方法没有执行，而通知方法执行了
     *  分析：
     *      通过对比动态代理中的环绕通知，发现动态代理的环绕通知中有明确的切入点方法调用。
     *  解决：
     *      spring框架为我们提供了一个接口ProceedingJoinPoint，该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的一个参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     *      proceed()方法的参数是调用业务层方法的参数，可以通过getArgs获取。
     *
     *  因为环绕通知的四种通知内容（也就是增强的过程）是自己写的，因此需要把业务层方法放到某个位置，这样才能分隔出四种通知。
     * @param pjp
     * @return
     */
    @Around("pt()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            System.out.println("环绕通知--前置");
            Object[] args = pjp.getArgs();  // 获取方法执行所需的参数
            rtValue = pjp.proceed(args);    // 明确调用业务层方法（切入点方法）
            System.out.println("环绕通知--后置");
            return rtValue;
        } catch (Throwable t){              // 必须使用Throwable，TODO:为什么，是因为包括异常和错误吗？
            System.out.println("环绕通知--异常");
            throw new RuntimeException(t);
        } finally {
            System.out.println("环绕通知--最终");
        }
    }
}
