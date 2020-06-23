package com.mybatisLearn.dao;

/**
 * Created by s on 2020/6/23 09:56.
 */

import com.mybatisLearn.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 账户的持久层接口
 */
@CacheNamespace(blocking = true)    // 开启二级缓存设置
public interface IAccountDao {

    /**
     * 查询所有账户
     * @return
     */
    @Select("select * from account")
    @Results(id="accountMapper", value = {
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "money", column = "money"),
            @Result(property = "user", column = "uid", one = @One(select = "com.mybatisLearn.dao.IUserDao.findById", fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据用户id查询账户
     * @param uid uid of account.
     * @return list of account with uid.
     */
    @Select("select * from account where uid=#{uid}")
    List<Account> findAccountsByUid(Integer uid);

    /**
     * 根据账户id查询
     * 用于测试缓存
     * @param id id of account.
     * @return account.
     */
    @Select("select * from account where id=#{id}")
    Account findAccountById(Integer id);

}
