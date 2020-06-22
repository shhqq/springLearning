package com.mybatisLearn.dao;

/**
 * Created by s on 2020/6/22 16:39.
 */

import com.mybatisLearn.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户的dao接口
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return all users.
     */
    @Select("select * from user")
    List<User> listAllUsers();

    /**
     * 保存用户
     * @param user user to insert.
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user user to update.
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param id id of user to delete.
     */
    void deleteUser(Integer id);
}
