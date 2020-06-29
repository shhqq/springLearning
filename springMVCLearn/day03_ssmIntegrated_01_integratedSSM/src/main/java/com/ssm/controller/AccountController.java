package com.ssm.controller;

/**
 * Created by s on 2020/6/29 09:27.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 表现层
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    /**
     * 表现层方法
     * @return 页面跳转
     */
    @RequestMapping("testFindAll")
    public String testFindAll(){
        System.out.println("表现层testFindAll方法");
        return "success";
    }
}
