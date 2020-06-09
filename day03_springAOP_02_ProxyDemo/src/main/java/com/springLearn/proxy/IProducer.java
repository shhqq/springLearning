package com.springLearn.proxy;

/**
 * Created by s on 2020/6/9 10:06.
 */

/**
 * 对生产者要求的接口，即实现该接口的类必须提供抽象函数的实现。
 * 基于接口的动态代理需要一个接口
 */
public interface IProducer {

    void saleProduct(float money);

    void afterService(float money);
}
