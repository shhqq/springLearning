package com.MVCLearn.interceptor;

/**
 * Created by s on 2020/6/28 17:05.
 */

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 * 自定义的拦截器需要实现HandlerInterceptor接口，此接口没有抽象方法，重写其中的方法即可。
 */
public class MyInterceptor1 implements HandlerInterceptor {

    /**
     * 重写预处理方法
     * 预处理方法在Controller方法执行前执行，如果返回值为true，放行，执行下一个拦截器，如果没有，则执行controller方法
     * 如果返回false，则不放行。
     * @param request servlet请求
     * @param response servlet响应
     * @param handler 执行
     * @return boolean，表示是否放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        System.out.println("Interceptor运行成功");
//        if(可以加条件){
//           // 可以设置，如果不满足条件，使用重定向
//           response.sendRedirect("...");
//           return false;
//        }
        return true;
    }
}
