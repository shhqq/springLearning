package com.MVCLearn.controller;

/**
 * Created by s on 2020/6/23 16:29.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 表现层的类
 * 如果使用注解，可以使用Controller
 */
@Controller
public class HelloController {

    @RequestMapping(path = "/hello")    //也可以使用value，与path相同
    public String helloHandler(){
        System.out.println("hello springMVC!");
        return "success";   // 指定跳转的视图地址，被ViewResolver解析为 /WEB-INF/pages/success.jsp
    }
}
