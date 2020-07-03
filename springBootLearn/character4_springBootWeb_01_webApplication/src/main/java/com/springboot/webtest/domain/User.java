package com.springboot.webtest.domain;

/**
 * Created by s on 2020/7/3 14:50.
 */

/**
 * 实体类，测试Thymeleaf使用
 */
public class User {
    private String name;
    private Integer age;
    /**
     * 有一个User成员变量
     */
    private User friend;

    public User(){}

    public User(String name, Integer age){
        this.name = name;
        this.age = age;
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

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
