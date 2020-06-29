package com.ssm.controller;

/**
 * Created by s on 2020/6/29 09:27.
 */

import com.ssm.domain.Account;
import com.ssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 表现层
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    /**
     * 提供业务层对象，并使用Autowired注解自动按类型注入
     */
    @Autowired
    private IAccountService accountService;

    /**
     * 表现层方法
     * @return 页面跳转
     */
    @RequestMapping("testFindAll")
    public String testFindAll(Model model){
        System.out.println("表现层testFindAll方法");
        // 整合：调用业务层方法，就实现了表现层调用业务层方法
        List<Account> accounts = accountService.findAll();
        // 将结果添加到Model对象中，在jsp中可以显示数据
        model.addAttribute("accounts", accounts);
        return "success";
    }

    /**
     * 测试保存账户方法，需要添加事务控制。
     * 保存账户后，重定向到查询所有账户方法。
     * @param account account to save.
     * @param request servlet request
     * @param response servlet response
     * @throws IOException
     */
    @RequestMapping("/testSaveAccount")
    public void testSaveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层的testSaveAccount方法");

        // 执行保存方法
        accountService.saveAccount(account);
        // 页面重定向到查询所有账户
        response.sendRedirect(request.getContextPath() + "/account/testFindAll");
        return;
    }
}
