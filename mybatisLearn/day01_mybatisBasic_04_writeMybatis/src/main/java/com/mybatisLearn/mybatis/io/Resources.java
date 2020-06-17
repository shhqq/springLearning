package com.mybatisLearn.mybatis.io;

import java.io.InputStream;

/**
 * Created by s on 2020/6/17 09:02.
 */

/**
 * 使用类加载器读取配置文件
 */
public class Resources {

    /**
     * 根据参数获取字节输入流
     * @param config Path of configuration file
     * @return
     */
    public static InputStream getResourceAsStream(String config){
        return Resources.class.getClassLoader().getResourceAsStream(config);
    }
}
