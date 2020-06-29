package com.ssm.controller;

/**
 * Created by s on 2020/6/29 09:27.
 */

import com.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 表现层
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    /**
     * 提供业务层对象，并使用Autowired注解自动按类型注入
     */
    @Autowired
    private IAccountService accountService;

    /**
     * 表现层方法
     * @return 页面跳转
     */
    @RequestMapping("testFindAll")
    public String testFindAll(){
        System.out.println("表现层testFindAll方法");
        // 整合：调用业务层方法，就实现了表现层调用业务层方法
        accountService.findAll();
        return "success";
    }
}
