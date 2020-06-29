package com.ssm.service;

/**
 * Created by s on 2020/6/29 09:21.
 */

import com.ssm.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口，业务层接口需要实现类
 */
public interface IAccountService {

    /**
     * 查询所有账户
     * @return list of account.
     */
    List<Account> findAll();

    /**
     * 保存账户
     * @param account the account to save.
     */
    void saveAccount(Account account);
}
