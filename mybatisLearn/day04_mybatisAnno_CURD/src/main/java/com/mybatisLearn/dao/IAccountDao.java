package com.mybatisLearn.dao;

/**
 * Created by s on 2020/6/23 09:56.
 */

import com.mybatisLearn.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 账户的持久层接口
 */
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
     * @return list of account with uid.
     */
    @Select("select * from account where uid=#{uid}")
    List<Account> findAccountsByUid(Integer uid);
}
