package com.mybatisLearn.mybatis.config;

/**
 * Created by s on 2020/6/17 14:56.
 */

/**
 * Mapper类，成员变量为sql语句及其要封装的结果类
 */
public class Mapper {

    private String queryString;
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
