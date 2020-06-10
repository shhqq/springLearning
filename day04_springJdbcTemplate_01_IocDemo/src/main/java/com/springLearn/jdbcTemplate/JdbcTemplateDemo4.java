package com.springLearn.jdbcTemplate;

/**
 * Created by s on 2020/6/10 14:23.
 */

import com.springLearn.dao.IAccountDao;
import com.springLearn.dao.impl.AccountDaoImpl;
import com.springLearn.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbc Template的基于注解的ioc
 *  使用Dao
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args){
        // 1. 构建spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

//        // 2. 创建jdbcTemplate对象
//        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        // 创建accountDao对象
        IAccountDao ad = ac.getBean("accountDao", AccountDaoImpl.class);

        Account account = ad.findAccountById(2);
        System.out.println(account);

        account.setMoney(3000f);
        ad.updateAccount(account);

        // 4. 执行操作
//        // jt.execute("insert into account(name, money) values('ddd', 3000)");
//        jt.update("insert into account(name, money) values('eee', 5000)");
    }
}
