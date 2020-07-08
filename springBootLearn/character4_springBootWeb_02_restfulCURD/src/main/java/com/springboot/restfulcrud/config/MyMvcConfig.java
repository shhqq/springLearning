package com.springboot.restfulcrud.config;

/**
 * Created by s on 2020/7/8 21:01.
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 扩展MVC的配置类，作用是代替springMVC的配置文件，
 * 1. 需要使用@Configuration注解，
 * 2. 在java8中，接口中也可以写函数体，所以实现接口时，这些函数的重写不是必须的。在新版本的WebMvcConfigurer
 *      中，有了函数体，所以不再需要继承WebMvcConfigurationAdapter，直接实现WebMvcConfigurer即可。
 * 3. 如果是扩展MVC，则不能用@EnableWebMvc注解
 */
@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * Configure simple automated controllers pre-configured with the response
     * status code and/or a view to render the response body. This is useful in
     * cases where there is no need for custom controller logic -- e.g. render a
     * home page, perform simple site URL redirects, return a 404 status with
     * HTML content, a 204 with no content, and more.
     *
     * 在这里添加ViewController，作用就相当于在springmvc的配置文件springmvc.xml中添加 mvc:view-controller
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 添加一个视图映射，浏览器发送springboot请求时，映射到success.html页面。
        // success由模板引擎thymeleaf进行解析，success.html需要放在templates文件夹中。
        // 添加视图映射的作用：就相当于在controller中添加一个请求的响应。
        registry.addViewController("/springboot").setViewName("success");
    }
}
