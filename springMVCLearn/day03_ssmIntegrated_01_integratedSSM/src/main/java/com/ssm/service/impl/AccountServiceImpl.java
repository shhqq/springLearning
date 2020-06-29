package com.ssm.service.impl;

/**
 * Created by s on 2020/6/29 09:25.
 */

import com.ssm.dao.IAccountDao;
import com.ssm.domain.Account;
import com.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层接口的实现类
 */
@Service(value = "accountService")
public class AccountServiceImpl implements IAccountService {

    /**
     * 添加持久层接口，使用自动按类型注入
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
        System.out.println("业务层，查询所有账户");
        return accountDao.findAll();
    }

    /**
     * 保存账户
     *
     * @param account the account to save.
     */
    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层，保存账户");
        accountDao.saveAccount(account);
    }
}
