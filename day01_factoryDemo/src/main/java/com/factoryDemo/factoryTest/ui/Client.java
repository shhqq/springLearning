package com.factoryDemo.factoryTest.ui;

/**
 * Created by s on 2020/6/3 09:54.
 */

import com.factoryDemo.factoryTest.factory.BeanFactory;
import com.factoryDemo.factoryTest.service.IAccountService;
import com.factoryDemo.factoryTest.service.impl.AccountServiceImpl;

/**
 * 表现层
 * 模拟表现层，用于调用业务层，在实际中，应该是一个servlet。
 */
public class Client {
    public static void main(String[] args){
        // 表现层调用业务层，使用new创建对象，这里是一个耦合
        // IAccountService as = new AccountServiceImpl();

        // 改为使用工厂模式获取对象
        // 由于返回的是Object，因此需要类型转换.
        // 为什么可以用接口强转？不就没有用到接口的实现了吗？由于反射获取对象时是具体类，因此可以转为接口，改为实现类也可以
        IAccountService as = (IAccountService) BeanFactory.getBean("accountService");

        // 调用业务层对象的方法
        as.saveAccount();
    }
}
