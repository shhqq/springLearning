package com.springLearn.service.impl;

/**
 * Created by s on 2020/6/5 10:17.
 */

import com.springLearn.dao.IAccountDao;
import com.springLearn.domain.Account;
import com.springLearn.service.IAccountService;
import com.springLearn.utils.TransactionManager;

import java.util.List;

/**
 * 业务层实现类
 *
 * 改造service，在业务层进行事务控制
 * service需要TransactionManager中的方法
 */
public class AccountServiceImpl_Manager implements IAccountService {

    // 业务层调用持久层
    IAccountDao accountDao;

    // 添加一个TransactionManager，用于事务控制，需要set方法由spring注入数据
    private TransactionManager txManager;

    /**
     * set method of TransactionManager
     * @param txManager
     */
    public void setTxManager(TransactionManager txManager){
        this.txManager = txManager;
    }

    // 此时需要spring注入数据，使用xml的方式，因此accountDao需要set方法
    public void setAccountDao(IAccountDao accountDao){
        this.accountDao = accountDao;
    }

    @Override
    public void saveAccount(Account account) {
        try {
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            accountDao.saveAccount(account);
            // 3. 提交事务
            txManager.commit();
        } catch (Exception e){
            // 4. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally{
            // 5. 释放连接
            txManager.release();
        }
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            List<Account> accounts = accountDao.findAllAccount();
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return accounts;
        } catch (Exception e){
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally{
            // 6. 释放连接
            txManager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try{
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            Account accounts = accountDao.findAccountById(accountId);
            // 3. 提交事务
            txManager.commit();
            // 4. 返回结果
            return accounts;
        } catch (Exception e){
            // 5. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally{
            // 6. 释放连接
            txManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            accountDao.deleteAccount(accountId);
            // 3. 提交事务
            txManager.commit();
        } catch (Exception e){
            // 4. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally{
            // 5. 释放连接
            txManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            // 1. 开启事务
            txManager.beginTransaction();
            // 2. 执行操作
            accountDao.updateAccount(account);
            // 3. 提交事务
            txManager.commit();
        } catch (Exception e){
            // 4. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally{
            // 5. 释放连接
            txManager.release();
        }
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
        try{
            // 1. 开启事务
            txManager.beginTransaction();
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

            int a = 1 / 0;
            // 2.6. 更新转入账户
            accountDao.updateAccount(target);
            // 3. 提交事务
            txManager.commit();
        } catch (Exception e){
            // 4. 回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally{
            // 5. 释放连接
            txManager.release();
        }

    }
}
