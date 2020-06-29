package com.ssm.service.impl;

/**
 * Created by s on 2020/6/29 18:30.
 */

import com.ssm.dao.IAccountDao;
import com.ssm.domain.Account;
import com.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    /**
     * 在spring的配置文件中配置mybatis所需的连接池，SqlSessionFactory工厂，dao扫描，以及事务控制后，
     * 可以使用注解注入dao接口的代理对象
     */
    @Autowired
    private IAccountDao accountDao;

    /**
     * 查询所有账户
     *
     * @return list of account.
     */
    @Override
    public List<Account> findAll() {
        System.out.println("业务层中的findAll方法");
        return accountDao.findAll();
    }

    /**
     * 保存账户
     *
     * @param account account to save.
     */
    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层中的saveAccount方法");
        accountDao.saveAccount(account);
    }
}
