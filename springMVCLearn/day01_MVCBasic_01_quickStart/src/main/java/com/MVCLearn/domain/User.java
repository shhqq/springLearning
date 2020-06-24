package com.MVCLearn.domain;

/**
 * Created by s on 2020/6/24 11:48.
 */

import java.io.Serializable;
import java.util.*;

/**
 * 创建一个实体类，用于作为请求的参数
 * 注意实体类要实现Serializable接口
 */
public class User implements Serializable {
    private String name;
    private Integer age;
    private Date birthday;
    private Account account;
    private Set<Account> accounts;
    private Map<String, Account> accountMap;

    public User(){
        accounts = new HashSet<>();
        Account a = new Account();
        a.setId("23");
        a.setMoney(234.0);
        accounts.add(a);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Map<String, Account> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(Map<String, Account> accountMap) {
        this.accountMap = accountMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", account=" + account +
                ", accounts=" + accounts +
                ", accountMap=" + accountMap +
                '}';
    }
}
