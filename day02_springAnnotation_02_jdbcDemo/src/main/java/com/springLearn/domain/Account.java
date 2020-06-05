package com.springLearn.domain;

/**
 * Created by s on 2020/6/5 10:30.
 */

import java.io.Serializable;

/**
 * 账户的实体类
 * 实现serializable接口，用户类的序列化
 */
public class Account implements Serializable {
    // 这里都用包装数据类型，为了判断是否为空
    private Integer id;
    private String name;
    private Float money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
