package com.springLearn.service.impl;

/**
 * Created by s on 2020/6/5 10:17.
 */

import java.util.List;

import com.springLearn.dao.IAccountDao;
import com.springLearn.domain.Account;
import com.springLearn.service.IAccountService;
import com.springLearn.utils.TransactionManager;

/**
 * 业务层实现类
 *
 * 改造service，在业务层进行事务控制
 * service需要TransactionManager中的方法
 */
public class AccountServiceImpl implements IAccountService {

    // 业务层调用持久层
    IAccountDao accountDao;

    // 使用代理后，这里TransactionManager不再需要
//    // 添加一个TransactionManager，用于事务控制，需要set方法由spring注入数据
//    private TransactionManager txManager;
//
//    /**
//     * set method of TransactionManager
//     * @param txManager
//     */
//    public void setTxManager(TransactionManager txManager){
//        this.txManager = txManager;
//    }

    // 此时需要spring注入数据，使用xml的方式，因此accountDao需要set方法
    public void setAccountDao(IAccountDao accountDao){
        this.accountDao = accountDao;
    }

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

    /**
     * 转账
     * 使用事务控制后，所有的操作都只要一个连接，如果产生异常，则会回滚操作。
     *
     * @param sourceName source name
     * @param targetName target name
     * @param money      money to transfer
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        // 2. 执行操作
        // 2.1. 查询转出账户
        Account source = accountDao.findAccountByName(sourceName);

        // 2.2. 查询转入账户
        Account target = accountDao.findAccountByName(targetName);

        // 2.3. 转出账户余额更改
        source.setMoney(source.getMoney() - money);

        // 2.4. 转入账户余额更改
        target.setMoney(target.getMoney() + money);

        // 2.5. 更新转出账户
        accountDao.updateAccount(source);

        int a = 1 / 0;      // 制造一个异常，用来检验事务的一致性
        // 2.6. 更新转入账户
        accountDao.updateAccount(target);
    }
}
