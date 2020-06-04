package com.springDemo.dao.impl;

/**
 * Created by s on 2020/6/3 09:51.
 */

import com.springDemo.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层接口的实现类
 */

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    /**
     * 账户的持久层保存方法。这个是具体的方法
     */
    @Override
    public void saveAccount() {
        System.out.println("Account saved.");
    }
}
