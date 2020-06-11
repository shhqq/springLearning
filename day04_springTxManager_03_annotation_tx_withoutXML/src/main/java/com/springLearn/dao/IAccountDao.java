package com.springLearn.dao;

/**
 * Created by s on 2020/6/10 16:18.
 */

import com.springLearn.domain.Account;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {

    Account findAccountById(int id);

    Account findAccountByName(String name);

    void updateAccount(Account account);
}
