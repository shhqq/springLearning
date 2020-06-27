package com.MVCLearn.controller;

/**
 * Created by s on 2020/6/27 16:18.
 */

import com.MVCLearn.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    /**
     * 测试无返回值
     * 请求转发是一次请求，不用编写项目的名称
     * 重定向是两次请求，需要编写项目的名称
     */
    @RequestMapping("testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("testVoid method executed.");
        // 第一种是请求转发--编写请求转发的程序
        // 这里不会调用视图解析器，因此需要写全路径
        // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        // 第二种是重定向，重定向需要项目名称，使用request.getContextPath()可以获取项目名称
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        // 第三种是直接进行响应
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("测试");

        // 添加一个return语句，表示执行到此处就停止。
        return;

    }

    /**
     * 返回值为ModelAndView对象
     * ModelAndView对象是model和View的结合，可以保存数据和指定跳转视图。
     * 事实上，使用String作为返回值，底层也是调用了ModelAndView。
     * @return
     */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        // 1. 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();

        // 2. 模拟查询数据
        User user = new User();
        user.setUsername("Mike");
        user.setPassword("324");
        user.setAge(12);

        // 3. 保存数据到Model中
        mv.addObject("user", user);

        // 4. 设置View，即跳转页面
        mv.setViewName("success");

        // 5. 返回ModelAndView对象
        return mv;
    }

    /**
     * 测试forward 和 redirect关键字
     * 不能使用视图解析器，需要将路径写全
     * @return 跳转页面
     */
    @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect");
        // 使用forward关键字进行页面跳转
//        return("forward:/WEB-INF/pages/success.jsp");

        // 使用redirect关键字跳转页面
        // 注意redirect不能重定向到WEB-INF下的页面
        // 使用redirect关键字不需要添加项目名称
        return("redirect:/index.jsp");
    }
}
