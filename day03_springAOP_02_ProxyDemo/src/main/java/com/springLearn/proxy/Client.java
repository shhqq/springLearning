package com.springLearn.proxy;

/**
 * Created by s on 2020/6/9 10:09.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {

    public static void main(String[] args){
        // 匿名内部类访问外部成员变量时，该变量需要是final的。
        final Producer producer = new Producer();
        // 直接使用的方式
        // producer.saleProduct(10000F);

        // 改为使用动态代理
        /**
         * 动态代理：
         *      特点：字节码随用随创建，随用随加载（与装饰者模式的区别）
         *      作用：不修改源码的基础上，对方法进行增强
         *      分类：
         *          基于接口的动态代理
         *          基于子类的动态代理
         *      基于接口的动态代理：
         *          涉及的类：Proxy
         *          提供者：jdk官方
         *      如何创建代理对象：
         *          使用Proxy类的newProxyInstance方法
         *      创建代理对象的要求：
         *          被代理的类最少实现一个接口，如果没有则不能使用。
         *      newProxyInstance方法的参数：
         *          classLoader: 类加载器
         *              用于加载代理对象字节码的，和被代理对象使用相同的类加载器。  固定写法
         *          class[]: 字节码数组
         *              用于让代理对象和被代理对象具有相同的方法--即实现相同的接口. 固定写法
         *          InvocationHandler: 用于提供增强的代码
         *              它是让我们写如何代理，我们一般都是写一个该接口的实现类，通常情况下是匿名内部类，但不必须。
         *              此接口的实现类都是谁用谁写。
         */

        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 该方法的作用：执行被代理对象的任何方法都会先经过该方法。
                     * @param proxy     代理对象的引用
                     * @param method    当前执行的方法
                     * @param args      当前执行的方法的参数
                     * @return          和被代理对象的方法有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 这里写增强的代码

                        Object returnValue = null;

                        // 1. 获取方法执行的参数
                        float money = (float) args[0];
                        // 2. 判断当前方法是否为销售
                        if("saleProduct".equals(method.getName())){
                            returnValue = method.invoke(producer, money * 0.8F);     // 方法增强
                        }
                        return returnValue;
                    }
                });

        // 使用代理调用方法
        proxyProducer.saleProduct(10000F);
    }
}
