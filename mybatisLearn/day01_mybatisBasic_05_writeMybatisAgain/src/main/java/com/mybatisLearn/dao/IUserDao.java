package com.mybatisLearn.dao;

/**
 * Created by s on 2020/6/16 09:32.
 */

import com.mybatisLearn.domain.User;

import java.util.List;

/**
 * User的dao持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有用户
     * @return 返回用户列表
     */
    List<User> findAll();
}
