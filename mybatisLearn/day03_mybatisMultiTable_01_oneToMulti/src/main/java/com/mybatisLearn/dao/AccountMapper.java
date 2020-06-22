package com.mybatisLearn.dao;

/**
 * Created by s on 2020/6/22 09:09.
 */

import com.mybatisLearn.domain.Account;

import java.util.List;

/**
 * Account 的mapper接口，也是dao接口
 */
public interface AccountMapper {

    /**
     * 列出所有账户
     * @return A list of Accounts.
     */
    List<Account> listAccounts();

    /**
     * 使用延迟加载，加载account的user变量
     * @return A list of accounts.
     */
    List<Account> listAccountsUsingLazyLoading();

    /**
     * 根据用户id获取该用户下的所有账户
     * @param uid id of user.
     * @return
     */
    List<Account> getAccountsByUid(Integer uid);
}
