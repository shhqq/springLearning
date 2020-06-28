package com.MVCLearn.controller;

import com.MVCLearn.utils.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by s on 2020/6/28 16:20.
 */
@Controller
@RequestMapping("user/")
public class UserController {

    @RequestMapping("handler")
    public String handler() throws SysException {
        System.out.println("Handler method executed");
        int a = 1;
//        if(a == 1){
//            throw new SysException("error: a == 1");    // 此处抛出一个异常
//        }
        return "success";
    }
}
