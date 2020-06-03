package com.factoryDemo.factoryTest.factory;

import com.factoryDemo.factoryTest.service.IAccountService;
import com.factoryDemo.factoryTest.service.impl.AccountServiceImpl;

/**
 * Created by s on 2020/6/3 15:23.
 */

/**
 * 模拟一个工厂类，该类可能存在于一个jar包中，无法修改源码，不确定是否提供默认构造函数。
 */
public class StaticFactory {

    /**
     * 改为静态方法
     * @return
     */
    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
