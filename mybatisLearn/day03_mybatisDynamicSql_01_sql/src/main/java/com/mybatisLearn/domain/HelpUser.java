package com.mybatisLearn.domain;

/**
 * Created by s on 2020/6/18 10:23.
 */

import java.util.List;

/**
 * 一个辅助类，其中包含一个User对象，用于测试包含User的类的查询
 */
public class HelpUser {
    private User user;
    private Integer age;
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
