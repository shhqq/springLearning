package com.MVCLearn.controller;

/**
 * Created by s on 2020/6/27 16:18.
 */

import com.MVCLearn.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String testString(Model model){
        System.out.println("testString method executed.");

        User user = new User();
        user.setUsername("Jack");
        user.setPassword("123");
        user.setAge(23);
        model.addAttribute("Jack", user);

        return "success";
    }
}
