package com.springLearn.jdbcTemplate;

/**
 * Created by s on 2020/6/10 14:23.
 */

import com.springLearn.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * jdbc Template的基于注解的ioc
 * jdbc 基本操作CRUD
 *
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args){
        // 1. 构建spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        // 2. 创建jdbcTemplate对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

        // 4. 执行操作
        // jt.execute("insert into account(name, money) values('ddd', 3000)");

        // 1. 保存
//        jt.update("insert into account(name, money) values(?,?)", "fff", 6000);
        // 2. 更新
//        jt.update("update account set money = ? where id = ?", 2800, 2);
        // 3. 删除
//        jt.update("delete from account where id = ?", 3);

        // 4. 查询
        // 4.1. 使用自己写的结果集封装
//        List<Account> accounts = jt.query("select * from account where money > ?", new AccountRowMapper(),2000);
        // 4.2. 使用spring自带的结果集封装
//        List<Account> accounts = jt.query("select * from account where money > ?", new BeanPropertyRowMapper<>(Account.class),2000);
//
//        for(Account a: accounts){
//            System.out.println(a);
//        }

        // 5. 查询一个，在实际应用中，查询一个也使用这个方法，带有RowMapper的query方法。
//        List<Account> accountsRes = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class),1);
//        System.out.println(accountsRes.isEmpty()? "没有结果":accountsRes.get(0));

        // 6. 查询返回一行一列（使用聚合函数）
        // queryForList可以返回结果集合，一般是map集合
        // queryForObject可以指定返回类型
        long res = jt.queryForObject("select count(*) from account where money > ?", long.class, 3000);
        System.out.println(res);
    }
}

/**
 * 定义Account的封装策略，它是查询结果集处理的一个封装
 * 自己实现一个RowMapper的实现类，作用是封装查询结果为一个实体类，如Account。
 * 这个类的作用与dbutils提供的beanListHandler作用类似，都是结果集处理的一个封装
 */
class AccountRowMapper implements RowMapper<Account>{

    /**
     * 把结果集中的数据封装到Account中，然后由spring将每个Account加到集合中
     * @param resultSet 查询结果
     * @param i         暂不清楚
     * @return          泛型，与RowMapper泛型一致
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
