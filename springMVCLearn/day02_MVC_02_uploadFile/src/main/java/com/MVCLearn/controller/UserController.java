package com.MVCLearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by s on 2020/6/28 11:14.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 上传文件
     * @return
     */
    @RequestMapping("/testUploadFile")
    public String testUploadFile(){
        System.out.println("testUploadFile method executed.");
        return "success";
    }
}
