package com.MVCLearn.utils;

/**
 * Created by s on 2020/6/24 13:51.
 */

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义参数类型转换器
 * 将"2020-02-20"转换为Date类型
 */
public class SpringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(s);
        } catch (Exception e){
            throw new RuntimeException("日期格式错误");
        }
    }
}
