package com.mybatisLearn.domain;

/**
 * Created by s on 2020/6/23 09:53.
 */

import java.io.Serializable;

/**
 * 账户的实体类
 */
public class Account implements Serializable {

    private Integer id;
    private Integer uid;
    private Double money;

    /**
     * 每个账户只属于一个用户，体现多对一，或者从账户角度看是一对一
     */
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
