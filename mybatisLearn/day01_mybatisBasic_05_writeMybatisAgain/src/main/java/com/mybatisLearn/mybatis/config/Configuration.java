package com.mybatisLearn.mybatis.config;

/**
 * Created by s on 2020/6/17 14:53.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 保存数据库连接信息和Mapper对象
 */
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;

    // 这里必须new一个对象，否则set方法中的putAll会产生空指针异常
    private Map<String, Mapper> mappers = new HashMap<>();

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    /**
     * mapper的set方法需要使用追加，而不是覆盖
     * @param mappers
     */
    public void setMappers(Map<String, Mapper> mappers) {
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
