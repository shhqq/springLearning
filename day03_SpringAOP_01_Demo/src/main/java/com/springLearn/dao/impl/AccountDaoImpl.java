package com.springLearn.dao.impl;

/**
 * Created by s on 2020/6/5 10:19.
 */

import com.springLearn.dao.IAccountDao;
import com.springLearn.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    // 需要一个数据库操作对象
    private QueryRunner runner;
    // 该对象也由spring提供，使用xml方式，因此，也需要set方法
    public void setRunner(QueryRunner runner){
        this.runner = runner;
    }

    /**
     * 保存
     *
     * @param account
     */
    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 按照id查询
     *
     * @param accountID
     * @return
     */
    @Override
    public Account findAccountById(Integer accountID) {
        try{
            return runner.query("select * from account where id= ?", new BeanHandler<Account>(Account.class), accountID);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除
     *
     * @param accountId
     */
    @Override
    public void deleteAccount(Integer accountId) {
        try{
            runner.update("delete from account where id = ?", accountId);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新
     *
     * @param account
     */
    @Override
    public void updateAccount(Account account) {
        try{
            runner.update("update account set name = ?, money= ? where id= ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
