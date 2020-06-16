package com.mybatisLearn.dao.impl;

import com.mybatisLearn.dao.IUserDao;
import com.mybatisLearn.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by s on 2020/6/16 13:59.
 */
public class UserDaoImpl implements IUserDao {

    // 需要一个SqlSessionFactory生成SqlSession
    private SqlSessionFactory factory;

    // 生成一个构造方法，要求传入SqlSessionFactory
    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    /**
     * 实现findAll方法
     * 这里要使用dao的映射配置文件中的sql语句，注意statement中要写namespace+id
     * @return
     */
    @Override
    public List<User> findAll(){
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.mybatisLearn.dao.IUserDao.findAll");
        session.close();
        return users;
    }
}
