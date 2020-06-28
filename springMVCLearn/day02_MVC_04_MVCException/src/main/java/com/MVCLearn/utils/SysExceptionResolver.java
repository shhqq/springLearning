package com.MVCLearn.utils;

/**
 * Created by s on 2020/6/28 16:33.
 */

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建一个异常处理器
 * 异常处理器需要实现HandlerExceptionResolver接口
 */
public class SysExceptionResolver implements HandlerExceptionResolver {

    /**
     * 异常的处理方法
     * @param httpServletRequest servlet请求
     * @param httpServletResponse servlet响应
     * @param o object 暂时没用到
     * @param e 异常
     * @return 返回一个ModelAndView，可以配置数据和跳转路径
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        // 1. 获取异常对象
        SysException sysException = null;
        if(e instanceof SysException){
            sysException = (SysException) e;
        } else {
            sysException = new SysException("系统正在维护中...");
        }

        // 2. 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", sysException.getMessage());    // 封装错误信息
        mv.setViewName("error");        // 跳转路径
        return mv;
    }
}
