package com.springboot.webtest.controller;

import com.springboot.webtest.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * Created by s on 2020/7/3 09:22.
 */

/**
 * 表现层
 * 测试静态资源映射
 * 1. 静态资源映射包括webjars映射和文件夹映射
 *      webjars映射到/WETA-INF/resources/webjars
 *      其他静态资源/**映射到 /public/, /resources/, /static/, /META-INF/resources/
 * 2. 主页会到/**找
 * 3. 图标 也会到/**找
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String testHello(){
        return "hello";
    }

    /**
     * 测试跳转页面
     * 将html页面放在templates文件夹下，就可以自动跳转
     * @return
     */
    @RequestMapping("/success")
    public String success(Map<String, Object> maps){
        maps.put("hello", "world");
        return "success";
    }

    @RequestMapping("thymeleafTest")
    public String thymeleafTest(Model model){
        User user = new User();
        user.setName("Jack");
        user.setAge(23);
        user.setFriend(new User("Mike", 28));
        model.addAttribute("user", user);
        model.addAttribute("hello", "你好");

        // thymeleaf内置的全局对象变量
        model.addAttribute("today", new Date());
        return "success";
    }
}
