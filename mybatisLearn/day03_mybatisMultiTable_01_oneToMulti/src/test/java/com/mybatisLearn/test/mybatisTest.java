package com.mybatisLearn.test;

import com.mybatisLearn.dao.AccountMapper;
import com.mybatisLearn.dao.IUserDao;
import com.mybatisLearn.domain.Account;
import com.mybatisLearn.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by s on 2020/6/19 17:50.
 */

/**
 * 本项目是从来测试mybatis的多表操作
 * 
 */

public class mybatisTest {

    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;
    private AccountMapper accountMapper;

    @Before // 测试方法执行前
    public void init() throws Exception{
        in = Resources.getResourceAsStream("XmlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        // 创建代理对象
        userDao = session.getMapper(IUserDao.class);
        accountMapper = session.getMapper(AccountMapper.class);
    }

    @After // 测试方法执行后
    public void destroy() throws Exception{
        session.commit();
        in.close();
        session.close();
    }

    /**
     * 测试查询所有用户方法
     */
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试查询所有账户方法
     */
    @Test
    public void testListAccounts(){
        List<Account> accounts = accountMapper.listAccounts();
//        for(Account account:accounts){
//            System.out.println(account);
//        }
        // 1. 使用lambda表达式
        accounts.forEach(account -> System.out.println(account));
        // 2. 使用方法引用
        accounts.forEach(System.out::println);
        // 3. 使用匿名内部类，使用消费接口
        accounts.forEach(new Consumer<Account>() {
            @Override
            public void accept(Account account) {
                System.out.println(account);
            }
        });
    }
}
