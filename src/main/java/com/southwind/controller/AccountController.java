package com.southwind.controller;

import com.southwind.dto.AccountDto;
import com.southwind.form.AccountForm;
import com.southwind.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author lzk
 * @create 2022-07-05 16:11
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 管理员登录
     *
     * @param accountForm
     * @param session
     * @return
     */
    @PostMapping("/login")
    public ModelAndView login(AccountForm accountForm, HttpSession session) {
        AccountDto accountDto = this.accountService.login(accountForm);
        ModelAndView modelAndView = new ModelAndView();
        switch (accountDto.getCode()) {
            case -1:
                modelAndView.setViewName("login");
                modelAndView.addObject("usernameError", "用户名错误");
                break;
            case -2:
                modelAndView.setViewName("login");
                modelAndView.addObject("passwordError", "密码错误");
                break;
            case 0:
                switch (accountForm.getType()) {
                    case "systemAdmin":
                        modelAndView.setViewName("systemadmin");
                        session.setAttribute("systemAdmin", accountDto.getAdmin());

                        break;
                    case "dormitoryAdmin":
                        modelAndView.setViewName("dormitoryadmin");
                        session.setAttribute("dormitoryAdmin", accountDto.getAdmin());
                        break;
                }
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //销毁session
        session.invalidate();
        //返回登录页面
        return "login";
    }
}
