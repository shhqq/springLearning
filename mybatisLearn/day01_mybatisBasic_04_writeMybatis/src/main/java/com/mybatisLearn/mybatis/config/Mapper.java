package com.mybatisLearn.mybatis.config;

/**
 * Created by s on 2020/6/17 09:21.
 */

/**
 * Mapper类，存放sql语句，以及对应的结果封装的实体类
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
