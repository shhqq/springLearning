package com.mybatisLearn.dao;

/**
 * Created by s on 2020/6/22 16:39.
 */

import com.mybatisLearn.domain.User;
import org.apache.ibatis.annotations.*;

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
    @Results(id="userMapper", value = {
            @Result(id=true,property = "username",column = "username"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "birthday", column="birthday"),
            @Result(property="address", column = "address")
    })
    List<User> listAllUsers();

    /**
     * 保存用户
     * @param user user to insert.
     */
    @Insert("insert into user(username, sex, birthday, address ) values (#{username}, #{sex}, #{birthday}, #{address})")
    @SelectKey(keyProperty = "id", keyColumn = "id", statement = "select last_insert_id()", resultType = Integer.class, before = false)
    void saveUser(User user);

    /**
     * 更新用户
     * @param user user to update.
     */
    @Update("update user set username=#{username}, sex=#{sex}, birthday=#{birthday}, address=#{address} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param id id of user to delete.
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    /**
     * 查询一个
     * @param id id of user.
     * @return user
     */
    @Select("select * from user where id=#{id}")
    @ResultMap("userMapper")    // 引用上面定义的results
    User findById(Integer id);

    /**
     * 根据名称模糊查询
     * @param username username
     * @return list of users.
     */
    @Select("select * from user where username like #{username}")
//    @Select("select * from user where username like '%${value}%'")
    List<User> findUsersFuzzy(String username);

    /**
     * 查询总数
     * @return
     */
    @Select("select count(*) from user")
    int findTotal();
}
