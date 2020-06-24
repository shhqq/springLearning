package com.MVCLearn.controller;

/**
 * Created by s on 2020/6/23 16:29.
 */

import com.MVCLearn.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 表现层的类
 * 如果使用注解，可以使用Controller
 */
@Controller
public class HelloController {

    /**
     * 处理请求
     * @param username username
     * @param age 当请求参数和方法参数不一致时，使用RequestParam注解指定对应关系
     * @return 返回要执行的方法
     */
    @RequestMapping(path = "/hello")    //也可以使用value，与path相同
    public String helloHandler(String username, @RequestParam(name = "userAge") Integer age){
        System.out.println("hello springMVC!");
        System.out.println(username);
        System.out.println(age);
        return "success";   // 指定跳转的视图地址，被ViewResolver解析为 /WEB-INF/pages/success.jsp
    }

    /**
     * 测试参数绑定，参数为JavaBean类型，其中包含其他实体类作为成员变量，还包含集合类型
     * @return
     */
    @RequestMapping(path = "/userHandler/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return "success";
    }

}
