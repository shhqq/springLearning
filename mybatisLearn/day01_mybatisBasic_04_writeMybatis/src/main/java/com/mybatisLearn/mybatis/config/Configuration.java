package com.mybatisLearn.mybatis.config;

/**
 * Created by s on 2020/6/17 09:18.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 用于存放配置信息的类
 * 包含数据库连接信息、
 */
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;

    // 这里必须new一个对象，否则set方法中的putAll会产生空指针异常
    private Map<String, Mapper> mappers = new HashMap<>();

    public Map getMappers() {
        return mappers;
    }

    /**
     * 注意 mappers的set方法需要加入而不是赋值
     * @param mappers
     */
    public void setMappers(Map mappers) {
//        this.mappers = mappers;
        this.mappers.putAll(mappers);
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
