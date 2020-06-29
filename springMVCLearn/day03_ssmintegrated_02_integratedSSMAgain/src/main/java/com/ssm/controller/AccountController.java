package com.ssm.controller;

/**
 * Created by s on 2020/6/29 17:47.
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
 * 表现层Controller
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    /**
     * 在web.xml中配置spring配置文件后，就可以注入业务层对象
     */
    @Autowired
    private IAccountService accountService;

    /**
     * 表现层方法
     * @return 页面跳转
     */
    @RequestMapping("/testFindAll")
    public String testFindAll(Model model){
        System.out.println("表现层的testFindAll方法执行");
        // 使用业务层对象调用方法
        List<Account> accounts = accountService.findAll();
        if(accounts != null){
            accounts.forEach(System.out::println);
        }
        model.addAttribute("accounts", accounts);
        return "success";
    }

    /**
     * 测试表现层保存方法
     * @param account account to save.
     * @param request servlet request.
     * @param response servlet response.
     * @throws IOException
     */
    @RequestMapping("/testSaveAccount")
    public void testSaveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层的testSaveAccount方法执行");
        accountService.saveAccount(account);
        // 重定向至查询所有的方法
        response.sendRedirect(request.getContextPath() + "/account/testFindAll");
        return;
    }
}
