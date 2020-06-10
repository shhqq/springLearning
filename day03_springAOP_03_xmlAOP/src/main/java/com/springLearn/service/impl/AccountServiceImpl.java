package com.springLearn.service.impl;

/**
 * Created by s on 2020/6/9 17:04.
 */

import com.springLearn.service.IAccountService;

/**
 * 业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    /**
     * 保存账户
     */
    @Override
    public void saveAccount() {
        System.out.println("saveAccount method invoked.");
        int i = 1 / 0;      // 制造一个异常，用于测试四种通知和环绕通知
    }

    /**
     * 更新账户
     *
     * @param i parameter type：integer.
     */
    @Override
    public void updateAccount(int i, int j) {
        System.out.println("updateAccount method invoked.");
    }

    /**
     * 删除账户
     *
     * @return return an integer.
     */
    @Override
    public int deleteAccount() {

        System.out.println("deleteAccount method invoked.");
        return 0;
    }
}
