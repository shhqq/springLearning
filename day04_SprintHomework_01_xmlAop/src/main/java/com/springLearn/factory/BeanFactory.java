package com.springLearn.factory;

/**
 * Created by s on 2020/6/9 12:33.
 */

import com.springLearn.domain.Account;
import com.springLearn.service.IAccountService;
import com.springLearn.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service代理对象的工厂
 */
public class BeanFactory {

    /**
     * 需要一个TransactionManager，而且由spring提供
     */
    private TransactionManager txManager;
    private IAccountService accountService;

    public void setTxManager(TransactionManager txManager){
        this.txManager = txManager;
    }

    /**
     * 使用spring注入数据
     * @param accountService
     */
    public void setAccountService(IAccountService accountService){
        this.accountService = accountService;
    }

    /**
     * 获取AccountService的代理对象
     * @return
     */
    public IAccountService getAccountService(){
        IAccountService proxyService = (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {

                    /**
                     * 调用被代理对象的所有的方法都会先经过该方法
                     * @param proxy     被代理对象，一般不会使用
                     * @param method    被代理对象的方法
                     * @param args      被代理对象的方法的参数
                     * @return          返回被代理对象的方法的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try{
                            // 1. 开启事务
                            txManager.beginTransaction();
                            // 2. 执行操作
                            rtValue = method.invoke(accountService, args);
                            // 3. 提交事务
                            txManager.commit();
                            // 4. 返回结果
                            return rtValue;
                        } catch (Exception e){
                            // 5. 回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally{
                            // 6. 释放连接
                            txManager.release();
                        }
                    }
                });
        return proxyService;
    }
}
