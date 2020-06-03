package com.factoryDemo.factoryTest.service.impl;

/**
 * Created by s on 2020/6/3 09:43.
 */

import com.factoryDemo.factoryTest.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 * 业务层调用持久层，声明对象，调用持久层对象的方法。
 */
public class AccountServiceImpl implements IAccountService {

    /**
     * 成员变量，用于依赖注入示例
     */
    private String name;
    private int age;
    private Date birthday;

    /**
     * 带参的构造函数，该类没有默认构造函数
     * @param name
     * @param age
     * @param birthday
     */
    public AccountServiceImpl(String name, int age, Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println("account saved.");
    }
}
