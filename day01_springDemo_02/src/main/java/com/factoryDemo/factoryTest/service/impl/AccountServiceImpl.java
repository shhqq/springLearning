package com.factoryDemo.factoryTest.service.impl;

/**
 * Created by s on 2020/6/3 09:43.
 */

import com.factoryDemo.factoryTest.service.IAccountService;

/**
 * 账户的业务层实现类
 * 业务层调用持久层，声明对象，调用持久层对象的方法。
 */
public class AccountServiceImpl implements IAccountService {


    @Override
    public void saveAccount() {
        System.out.println("account saved.");
    }
}
