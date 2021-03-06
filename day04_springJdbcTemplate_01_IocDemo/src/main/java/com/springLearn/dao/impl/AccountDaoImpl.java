package com.springLearn.dao.impl;

/**
 * Created by s on 2020/6/10 16:20.
 */

import com.springLearn.dao.IAccountDao;
import com.springLearn.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

// 这个是spring提供的jdbcTemplateSupport
//import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
    /**
     * 创建jdbcTemplate对象，并生成set方法，由spring的ioc注入
     *
     * 在有多个Dao中，JdbcTemplate就是多余的代码，可以使用jdbcTemplateSupport
     */
//    private JdbcTemplate jdbcTemplate;
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }

    /**
     * 按ID查询
     * 由于ID为主键，查询结果最多有一个
     * @param id    id
     * @return
     */
    @Override
    public Account findAccountById(int id) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where id = ?",
                new BeanPropertyRowMapper<>(Account.class), id);
        return accounts.isEmpty()? null: accounts.get(0);
    }

    /**
     * 按名称查询
     * 与按ID查询不同，查询结果可能为0，也可能大于1，
     * @param name  name
     * @return
     */
    @Override
    public Account findAccountByName(String name) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where name = ?",
                new BeanPropertyRowMapper<>(Account.class), name);
        if(accounts.isEmpty()){
            return null;
        } else if(accounts.size() > 1){
            throw new RuntimeException("按名称查询结果不唯一");
        } else {
            return accounts.get(0);
        }
    }

    @Override
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name = ?, money = ? where id = ?",
                account.getName(), account.getMoney(), account.getId());
    }
}
