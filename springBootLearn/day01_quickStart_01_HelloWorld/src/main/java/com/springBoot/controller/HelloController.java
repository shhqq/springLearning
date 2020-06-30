package com.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by s on 2020/6/30 10:12.
 */

/**
 * 表现层Controller
 */

@Controller
public class HelloController {

    /**
     * Controller中的方法
     * @return 返回到http中的字符串
     */
    @RequestMapping("/hello")
    @ResponseBody   // 该注解表示方法的返回值直接返回到http响应中，而不是存入Model或解析为视图名
    public String hello(){
        return "hello world!";
    }
}
