package com.springLearn.service.impl;

/**
 * Created by s on 2020/6/11 12:39.
 */

import com.springLearn.dao.IAccountDao;
import com.springLearn.domain.Account;
import com.springLearn.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务层实现类
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) // 可以通过设置，设置为只读型事务，全局
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

//    public void setAccountDao(IAccountDao accountDao){
//        this.accountDao = accountDao;
//    }

    @Override
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)    // 对于特定方法的事务配置
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer money ...");
        // 1. 获取转入转出账户
        Account source = accountDao.findAccountByName(sourceName);

        Account target = accountDao.findAccountByName(targetName);

        // 2. 执行操作
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);

        // 3. 更新到数据库中
        accountDao.updateAccount(source);
        int i = 1 / 0;          // 设置一个异常，用于事务一致行性检查
        accountDao.updateAccount(target);
    }


}
