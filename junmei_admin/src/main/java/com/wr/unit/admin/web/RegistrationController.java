package com.wr.unit.admin.web;

import com.wr.unit.admin.entity.User;
import com.wr.unit.admin.service.AccountService;
import com.wr.unit.admin.web.exception.RegistrationException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by wangrui on 2015/4/17 .
 */
@Controller
public class RegistrationController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/register")
    public String register(  Model model, @ModelAttribute("user") User user  ) {
        user.getRoleList().clear();
        user.setName(user.getLoginName());
        try {
            accountService.registerUser(user);
        } catch (RegistrationException e) {
            model.addAttribute("REG_ERROR_MSG", e.getMessage());
        }
        return "redirect:login";
    }

    @RequestMapping(value = "/checkLoginName")
    @ResponseBody
    public String checkLoginName(@RequestParam("loginName") String loginName) {
        if ( accountService.findUserByLoginName( loginName ) == null ) {
            return "true";
        }
        return "false";
    }
}
