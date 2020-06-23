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
    private SqlSession session2;    // 开启另一个session，测试二级缓存

    @Before // 测试方法执行前执行
    public void init() throws Exception{
        in = Resources.getResourceAsStream("XmlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        session2 = factory.openSession();
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

    /**
     * 测试一级缓存
     */
    @Test
    public void testFindAccountById(){
        Account account = accountDao.findAccountById(1);

        // 调用session的commit，close，clearCache等会清空一级缓存
        session.clearCache();

        Account account1 = accountDao.findAccountById(1);
        System.out.println(account == account1);
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void testFindAccountByIdSecondLevelCache(){
        Account account = accountDao.findAccountById(1);
        session.clearCache();
        // 注意： 必须在这里将session关闭，才能实现二级缓存，可能是第一个session不关闭，第二个session不能在二级缓存中访问这个数据
        // 这里关闭后，destroy中的关闭就要取消，否则会报错。
        // session.close();
        System.out.println("使用另一个sqlSession");
        IAccountDao accountDao2 = session2.getMapper(IAccountDao.class);
        Account account2 = accountDao2.findAccountById(1);
        System.out.println(account == account2);
        session2.close();
    }
}
