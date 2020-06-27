package com.MVCLearn.controller;

/**
 * Created by s on 2020/6/27 16:18.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 持久层类
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 测试返回值为String
     * @return
     */
    @RequestMapping("/testString")
    public String testString(){
        System.out.println("testString method executed.");
        return "success";
    }
}
