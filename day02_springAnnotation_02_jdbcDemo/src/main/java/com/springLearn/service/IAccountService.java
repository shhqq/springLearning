package com.springLearn.service;

/**
 * Created by s on 2020/6/5 10:15.
 */

import com.springLearn.domain.Account;

import java.util.List;

/**
 * 业务层接口
 */
public interface IAccountService {
    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 按照id查询
     * @param accountID
     * @return
     */
    Account findAccountById(Integer accountID);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);
}
