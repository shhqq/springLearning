package com.springLearn.dao;

/**
 * Created by s on 2020/6/5 10:19.
 */

import com.springLearn.domain.Account;

import java.util.List;

/**
 * 持久层接口
 */
public interface IAccountDao {
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

    /**
     * 根据名称查找用户
     * 若不存在或出问题，则返回null
     * 若查询结果多余一个，则抛异常
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);
}
