package com.MVCLearn.controller;

/**
 * Created by s on 2020/6/24 10:20.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 表现层类
 */
@Controller
public class HandlerController {

    /**
     * 具体的执行方法
     * @return 返回值调用页面
     */
    @RequestMapping(path="/hello",method ={RequestMethod.GET})
    public String Handler(){
        System.out.println("HandlerMapping");
        return "success";   // 指定跳转的视图地址，被ViewResolver解析为 /WEB-INF/pages/success.jsp
    }
}
