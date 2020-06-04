package com.factoryDemo.factoryTest.service.impl;

/**
 * Created by s on 2020/6/3 09:43.
 */

import com.factoryDemo.factoryTest.service.IAccountService;

import java.util.*;

/**
 * 账户的业务层实现类
 * 业务层调用持久层，声明对象，调用持久层对象的方法。
 * 使用set方法注入成员变量
 */
public class AccountServiceImpl implements IAccountService {

    /**
     * 成员变量，用于依赖注入示例
     * 使用set方法注入
     * 成员变量包括基本数据类型和复杂类型（集合类型）
     */
    private String name;
    private int age;
    private Date birthday;

    private int[] myArray;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myProps;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setMyArray(int[] myArray) {
        this.myArray = myArray;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public void saveAccount() {
        System.out.println("account saved.");
        System.out.println(Arrays.toString(myArray));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
    }
}
