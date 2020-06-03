package com.factoryDemo.factoryTest.service.impl;

/**
 * Created by s on 2020/6/3 09:43.
 */

import com.factoryDemo.factoryTest.service.IAccountService;
import com.factoryDemo.factoryTest.dao.IAccountDao;
import com.factoryDemo.factoryTest.dao.impl.AccountDaoImpl;

/**
 * 账户的业务层实现类
 * 业务层调用持久层，声明对象，调用持久层对象的方法。
 */
public class AccountServiceImpl implements IAccountService {

    // 持久层接口，即业务层调用持久层接口，使用new创建对象，这里是一个耦合
    private IAccountDao accountDao = new AccountDaoImpl();

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
