package com.mybatisLearn.dao;

/**
 * Created by s on 2020/6/18 08:58.
 */

import com.mybatisLearn.domain.User;

import java.util.List;

/**
 * dao接口
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return list of User
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user User to save.
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user User to update.
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param id id of User to delete.
     */
    void deleteUser(Integer id);

    /**
     * 按名称查询，可以用来测试实体类成员变量名称与数据库列名不一致的情况
     * @param name name of User.
     * @return query result.
     */
    User findUserByName(String name);
}
