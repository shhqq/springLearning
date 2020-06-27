package com.MVCLearn.controller;

/**
 * Created by s on 2020/6/24 15:28.
 */

import com.MVCLearn.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用注解
 */
@Controller
@RequestMapping("/annotation")
@SessionAttributes(value="msg")     // 将msg存入到session域对象中一份，就可以在方法间共享
public class AnnotationTestController {

    /**
     *
     * @param name name
     * @return method
     */
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam(name="username") String name){
        System.out.println(name);
        return "success";
    }

    /**
     * 获取请求体
     * @param body
     * @return
     */
    @RequestMapping("testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    /**
     * 测试PathVariable注解
     * @param id id
     * @return method
     */
    @RequestMapping("testPathVariable/{id}")
    public String testPathVariable(@PathVariable Integer id){   //同样，当形参名与path一致时，注解中的value不是必须的，这句话好像不对
        System.out.println(id);
        return "success";
    }

    /**
     * 测试RequestHeader注解
     * @param header header
     * @return method
     */
    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "accept") String header){
        System.out.println(header);
        return "success";
    }

    /**
     * 测试CookieValue注解
     * @param cookie cookie
     * @return method
     */
    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println(cookie);
        return "success";
    }

    /**
     * ModelAttribute注解作用于方法上
     * 如果ModelAttribute修饰的方法没有提供返回值，那么这里需要使用ModelAttribute修饰方法的参数，并指定key
     * @param user user
     * @return return the user.
     */
    @RequestMapping("testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println(user);
        return "success";
    }

    /**
     * ModelAttribute注解作用于方法上，该方法会在testModelAttribute方法前执行
     * 如果不使用返回值，需要在方法参数中添加一个map，并将user对象添加到map中
     */
    @ModelAttribute
    public void showUser(String name, Map<String, User> map){
        System.out.println("show user method executed.");
        // 模拟从数据库查询结果--根据用户名查询用户
        User user1 = new User();
        user1.setName(name);
        user1.setAge(23);   // 这个并不会生效，而是会使用表单提交的数据

        // 填充表单未填充的数据，就相当于根据表单提交的name，查询数据库获得数据库中的数据，birthday就是表单中没有提交的数据，会使用数据库中的数据
        user1.setBirthday(new Date());
//        return user1;
        map.put("abc", user1);
    }


    /**
     * SessionAttributes注解的使用，
     * SessionAttributes注解需要加在类上
     */
    @RequestMapping("testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("test SessionAttributes.");
        // 底层会存储到request域对象中
        model.addAttribute("msg", "hello world");
        return "success";
    }

    /**
     * SessionAttributes添加的值的取值
     */
    @RequestMapping("getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("get SessionAttributes.");
        // 这里不能再使用Model，而要用实现类ModelMap，它有get方法，用于取值
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 删除SessionAttributes添加的变量
     * @param sessionStatus
     * @return
     */
    @RequestMapping("delSessionAttributes")
    public String delSessionAttributes(SessionStatus sessionStatus){
        System.out.println("del SessionAttributes.");
        sessionStatus.setComplete();    // 表示完成，会删除session域中的变量
        return "success";
    }
}
