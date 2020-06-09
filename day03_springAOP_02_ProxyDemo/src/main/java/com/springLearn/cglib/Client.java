package com.springLearn.cglib;

/**
 * Created by s on 2020/6/9 10:09.
 */


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 模拟一个消费者
 * 动态代理的子类实现方式
 * 需要引入cglib依赖，实测中，cglib版本3.x以上会报错，使用2.1_3可以。
 */
public class Client {

    public static void main(String[] args){
        // 匿名内部类访问外部成员变量时，该变量需要是final的。
        final Producer producer = new Producer();
        // 直接使用的方式
         producer.saleProduct(10000F);

        // 改为使用动态代理
        /**
         * 动态代理：
         *      特点：字节码随用随创建，随用随加载（与装饰者模式的区别）
         *      作用：不修改源码的基础上，对方法进行增强
         *      分类：
         *          基于接口的动态代理
         *          基于子类的动态代理
         *      基于子类的动态代理：
         *          涉及的类：Enhancer
         *          提供者：cglib库
         *      如何创建代理对象：
         *          使用Enhancer类的create方法
         *      创建代理对象的要求：
         *          被代理的类不能是最终类。因为最终类无法写子类
         *      create方法的参数：
         *          class: 字节码
         *              被代理的对象的类的字节码
         *          Callback: 用于提供增强的代码
         *              它是让我们写如何代理，我们一般都是写一个该接口的实现类，通常情况下是匿名内部类，但不必须。
         *              一般写MethodInterceptor接口的子接口实现类
         */

        System.out.println(producer.getClass());
        Producer cglibProducer = (Producer)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过该方法。
             * @param proxy
             * @param method
             * @param args
             *     以上三个参数与使用接口的代理相同
             * @param methodProxy   当前执行方法的代理对象--一般用不到
             * @return  与代理对象的方法返回值相同
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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

        // cglibProducer.saleProduct(10000F);
    }
}
