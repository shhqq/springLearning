package com.mybatisLearn.mybatis.io;

import java.io.InputStream;

/**
 * Created by s on 2020/6/17 14:44.
 */

/**
 * 使用类加载器获取字节输入流
 */
public class Resources {

    /**
     * 静态方法，直接返回该类的类加载器的获取字节输入流
     * @param filepath path of configuration file.
     * @return
     */
    public static InputStream getResourceAsStream(String filepath){
        return Resources.class.getClassLoader().getResourceAsStream(filepath);
    }
}
