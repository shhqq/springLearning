package com.springLearn.utils;

/**
 * Created by s on 2020/6/9 17:07.
 */

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {

    /**
     * 用于打印日志，计划让其在切入点方法执行前执行（切入点方法就是业务层方法）
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("Logger类中的printLog方法开始记录日志--前置通知");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("Logger类中的printLog方法开始记录日志--后置通知");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("Logger类中的printLog方法开始记录日志--异常通知");

    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("Logger类中的printLog方法开始记录日志--最终通知");

    }
}
