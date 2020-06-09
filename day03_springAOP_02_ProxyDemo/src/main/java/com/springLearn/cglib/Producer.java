package com.springLearn.cglib;

/**
 * Created by s on 2020/6/9 10:02.
 */


/**
 * 一个生产者
 * 1. 基于子类的代理，要求类不能是最终类
 * 2. 生产者具有一些方法，代理可以增强这些方法.
 */
public class Producer{

    /**
     * 销售
     * @param money price of product
     */
    public void saleProduct(float money){
        System.out.println("sell product, get money: " + money);
    }

    /**
     * 售后
     * @param money price of after-sale service.
     */
    public void afterService(float money){
        System.out.println("after-sale service, get money: " + money);
    }
}
