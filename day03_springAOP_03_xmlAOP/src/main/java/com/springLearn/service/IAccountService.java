package com.springLearn.service;

/**
 * Created by s on 2020/6/9 17:02.
 */

/**
 * 账户的业务层接口
 *
 * 本例不关注具体方法内容，关注返回值类型和参数类型
 */
public interface IAccountService {

    /**
     * 保存账户
     */
    void saveAccount();

    /**
     * 更新账户
     * @param i parameter type：integer.
     */
    void updateAccount(int i);

    /**
     * 删除账户
     * @return  return an integer.
     */
    int deleteAccount();
}
