package com.springLearn.utils;

/**
 * Created by s on 2020/6/8 14:46.
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类
 * 事务管理，主要是连接的自动提交改为手动提交，使用commit和rollback方法实现事务控制。
 * 包含了开启事务，提交事务，回滚事务，释放连接方法。
 */
@Component("txManager")
@Aspect
public class TransactionManager {

    /**
     * 当前线程的连接，同样需要提供set方法，由spring容器注入
     */
    @Autowired
    private ConnectionUtils connectionUtils;

//    public void setConnectionUtils(ConnectionUtils connectionUtils){
//        this.connectionUtils = connectionUtils;
//    }

    @Pointcut("execution(* com.springLearn.service.impl.*.*(..))")
    private void pt1(){};
    /**
     * 开启事务
     */
//    @Before("pt1()")
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }

    /**
     * 提交事务
     */
//    @AfterReturning("pt1()")
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }

    /**
     * 回滚事务
     */
//    @AfterThrowing("pt1()")
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }

    /**
     * 释放链接
     */
//    @After("pt1()")
    public void release(){
        // 线程中绑定着一个连接，close()只能还回连接池中，并不是真正的关闭
        try {
            connectionUtils.getThreadConnection().close();  // 关闭并还回连接池中
            connectionUtils.removeConnection();             // 还需要将线程与连接解绑
        } catch (SQLException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }

    /**
     * 使用环绕通知
     * @param pjp   ProceedingJoinPoint
     * @return  return the return value of pointcut method.
     */
    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            // 前置通知
            this.beginTransaction();
            Object[] args = pjp.getArgs();
            rtValue = pjp.proceed(args);

            // 后置通知
            this.commit();
            return rtValue;
        } catch (Throwable t){
            // 异常通知
            this.rollback();
            throw new RuntimeException(t);
        } finally{
            // 最终通知
            this.release();
        }
    }

}
