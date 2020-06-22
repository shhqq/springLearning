package com.mybatisLearn.dao;

/**
 * Created by s on 2020/6/19 17:36.
 */

import com.mybatisLearn.domain.User;

import java.util.List;

/**
 * dao接口
 */
public interface IUserDao {

    /**
     * 查询所有用户及其账户
     * @return list of users.
     */
    List<User> findAll();

    /**
     * 查询所有用户及其角色
     * @return
     */
    List<User> listUsersWithRole();
}
