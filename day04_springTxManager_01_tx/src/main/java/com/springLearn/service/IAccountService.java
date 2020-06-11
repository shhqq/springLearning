package com.springLearn.service;

/**
 * Created by s on 2020/6/11 12:37.
 */

import com.springLearn.domain.Account;

/**
 * 业务层接口
 */
public interface IAccountService {

    Account findAccountById(int id);

    void transfer(String sourceName, String targetName, Float money);

}
