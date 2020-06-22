package com.mybatisLearn.domain;

/**
 * Created by s on 2020/6/19 17:34.
 */

import java.io.Serializable;

/**
 * 账户的实体类
 */
public class Account implements Serializable {

    private Integer id;
    private Integer uid;
    private Double money;
    // 账户必须在某个用户下，所以添加用户成员变量
    private User user;

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
