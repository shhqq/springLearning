package com.mybatisLearn.test;

/**
 * Created by s on 2020/6/22 16:51.
 */

import com.mybatisLearn.dao.IAccountDao;
import com.mybatisLearn.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 测试类
 */
public class MybatisAccountTest {

    private InputStream in;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before // 测试方法执行前执行
    public void init() throws Exception{
        in = Resources.getResourceAsStream("XmlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }

    @After // 测试方法执行后释放资源
    public void destroy() throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    /**
     * 测试查询所有账户方法
     */
    @Test
    public void testListAll(){
        List<Account> accounts = accountDao.findAll();
        // 延迟加载中，如果不访问关联数据，则不会查询
        accounts.forEach(System.out::println);
    }
}
