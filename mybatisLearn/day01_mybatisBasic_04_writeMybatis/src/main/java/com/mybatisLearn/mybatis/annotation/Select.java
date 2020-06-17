package com.mybatisLearn.mybatis.annotation;

/**
 * Created by s on 2020/6/17 10:00.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于查询的注解，--实现Mybatis中的Select注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {

    /**
     * 配置sql语句
     * @return
     */
    String value();
}
