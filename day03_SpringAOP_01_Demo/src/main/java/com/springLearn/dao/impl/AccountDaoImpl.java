package com.springLearn.dao.impl;

/**
 * Created by s on 2020/6/5 10:19.
 */

import com.springLearn.dao.IAccountDao;
import com.springLearn.domain.Account;
import com.springLearn.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    // 需要一个数据库操作对象
    private QueryRunner runner;

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils){
        this.connectionUtils = connectionUtils;
    }

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
            // 由于bean.xml中runner不指定DataSource，这里需要第一个参数为Connection
            runner.update(connectionUtils.getThreadConnection(), "insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
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
            return runner.query(connectionUtils.getThreadConnection(), "select * from account", new BeanListHandler<Account>(Account.class));
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
            return runner.query(connectionUtils.getThreadConnection(), "select * from account where id= ?", new BeanHandler<Account>(Account.class), accountID);
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
            runner.update(connectionUtils.getThreadConnection(), "delete from account where id = ?", accountId);
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
            runner.update(connectionUtils.getThreadConnection(), "update account set name = ?, money= ? where id= ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据名称查找用户 find account by name.
     * 若不存在或出问题，则返回null
     * 若查询结果多余一个，则抛异常
     *
     * @param accountName   要查询的名称
     * @return
     */
    @Override
    public Account findAccountByName(String accountName) {
        try{
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(), "select * from account where name = ?", new BeanListHandler<Account>(Account.class), accountName);
            if(accounts == null || accounts.size() == 0){
                return null;
            } else if (accounts.size() > 1){
                throw new RuntimeException("数据错误，存在多个重复的名称");
            } else {
                return accounts.get(0);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
