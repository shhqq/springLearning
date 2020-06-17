package com.mybatisLearn.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by s on 2020/6/16 08:58.
 */

/**
 * ReadMe:
 * 本工程主要内容:
 *      1. 创建一个mybatis示例
 *          加入依赖（坐标） mybatis，mysql，log4j，junit（后两个不是mybatis必须的）
 *      2. 需要一个实体类
 *          在本示例中，该实体类的变量名需要和数据库中的列名一致。
 *      3. 创建User的Dao接口
 */

/**
 * 用户的实体类
 * 本案例中，实体类的成员变量名需要和数据库中的列名一致，
 * 这样可以使用mybatis直接将结果封装为实体类对象
 *
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
