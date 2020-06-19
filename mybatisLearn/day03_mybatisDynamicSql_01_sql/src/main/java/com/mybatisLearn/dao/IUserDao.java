package com.mybatisLearn.dao;

/**
 * Created by s on 2020/6/18 08:58.
 */

import com.mybatisLearn.domain.HelpUser;
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
     * 模糊查询
     * @param name 模糊查询条件
     * @return query result.
     */
    List<User> findUserFuzzyQuery(String name);

    /**
     * 使用User的封装类HelpUser作为参数
     * 测试OGNL
     * @param helpUser 包含User对象的类
     * @return User对象
     */
    User findUserFromHelpUser(HelpUser helpUser);

    /**
     * 按名称查询，可以用来测试实体类成员变量名称与数据库列名不一致的情况
     * @param name name of User.
     * @return query result.
     */
    User findUserByName(String name);

    List<User> findUserByCondition(User user);
}
