package com.MVCLearn.utils;

/**
 * Created by s on 2020/6/28 16:31.
 */

/**
 * 自定义异常类
 * 自定义的异常需要继承Exception类
 */
public class SysException extends Exception{

    private String message;

    // 构造方法
    public SysException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
