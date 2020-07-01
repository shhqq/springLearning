package com.springboot.controller;

import com.springboot.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by s on 2020/6/30 15:41.
 */
@Controller
public class HelloController {

    @Autowired
    Person person;


    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println(person);
        return "hello world..";
    }
}
