package com.ssm.dao;

/**
 * Created by s on 2020/6/29 09:22.
 */

import com.ssm.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户的持久层接口，持久层接口不需要实现类，是使用mybatis提供的代理实现类
 */
@Repository
public interface IAccountDao {

    /**
     * 查询所有账户
     * @return list of account.
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 保存账户
     * @param account the account to save.
     */
    @Insert("insert into account(name, money) values(#{name}, #{money})")
    void saveAccount(Account account);
}
