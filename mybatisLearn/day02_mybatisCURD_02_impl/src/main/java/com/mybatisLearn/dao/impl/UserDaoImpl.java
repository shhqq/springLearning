package com.mybatisLearn.dao.impl;

/**
 * Created by s on 2020/6/18 14:07.
 */

import com.mybatisLearn.dao.IUserDao;
import com.mybatisLearn.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * IUserDao接口的实现类
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    /**
     * 提供一个构造函数，传入一个SqlSessionFactory对象
     * @param factory
     */
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    /**
     * 查询所有
     *
     * @return list of User
     */
    @Override
    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.mybatisLearn.dao.IUserDao.findAll");
        // 注意关闭session
        session.close();
        return users;
    }

    /**
     * 保存用户
     *
     * @param user User to save.
     */
    @Override
    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("com.mybatisLearn.dao.IUserDao.saveUser", user);
        // 首先提交操作
        session.commit();
        // 释放session
        session.close();
    }

    /**
     * 更新用户
     *
     * @param user User to update.
     */
    @Override
    public void updateUser(User user) {
        SqlSession session = factory.openSession();
        session.update("com.mybatisLearn.dao.IUserDao.updateUser", user);
        // 首先提交操作
        session.commit();
        // 释放session
        session.close();
    }

    /**
     * 删除用户
     *
     * @param id id of User to delete.
     */
    @Override
    public void deleteUser(Integer id) {
        SqlSession session = factory.openSession();
        // TODO:注意这里使用update，而没有使用delete，以后会分析
        session.update("com.mybatisLearn.dao.IUserDao.deleteUser", id);
        // 首先提交操作
        session.commit();
        // 释放session
        session.close();
    }

    /**
     * 按名称查询，可以用来测试实体类成员变量名称与数据库列名不一致的情况
     *
     * @param name name of User.
     * @return query result.
     */
    @Override
    public User findUserByName(String name) {
        SqlSession session = factory.openSession();
        User user = session.selectOne("com.mybatisLearn.dao.IUserDao.findUserByName", name);

        // 释放session
        session.close();

        return user;
    }
}
