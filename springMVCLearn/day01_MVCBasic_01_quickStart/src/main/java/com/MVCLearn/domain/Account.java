package com.MVCLearn.domain;

import java.io.Serializable;

/**
 * Created by s on 2020/6/24 11:49.
 */
public class Account implements Serializable {

    private String id;
    private Double money;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", money=" + money +
                '}';
    }
}
