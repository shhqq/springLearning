package com.springLearn.service.impl;

/**
 * Created by s on 2020/6/5 10:17.
 */

import java.util.List;

import com.springLearn.dao.IAccountDao;
import com.springLearn.domain.Account;
import com.springLearn.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 业务层实现类
 */
// 改为注解的方式
@Service(value = "accountService")
public class AccountServiceImpl implements IAccountService {

    // 业务层调用持久层，改为使用注解后，set方法可以删除
    @Resource(name = "accountDao")
    IAccountDao accountDao;

    // 此时需要spring注入数据，使用xml的方式，因此accountDao需要set方法
//    public void setAccountDao(IAccountDao accountDao){
//        this.accountDao = accountDao;
//    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }
}
