/**
 * Copyright (c) 2018, 2019
 * Author:  Yue
 * Date:    2019/3/21 21:36
 * History:
 */
package com.scauxg.restaurant.common;

import com.scauxg.restaurant.user.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 信息转发
 *
 * @author Yue
 * @create 2019/3/21
 * @since 1.0.0
 */
@Controller
public class MainController {

    @GetMapping(value = "/index")//{"/index","/","hello"}
    public String index() {
        return "index";
    }


    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/permsError")
    public String permsError() {
        return "error/perms";
    }

    @PostMapping("/entry")
    @ResponseBody
    public ReturnResult entry(String username, String password, Boolean rememberMe, ModelMap modelMap, HttpServletRequest requeest, HttpSession session) {
        // 获取subject
        Subject subject = SecurityUtils.getSubject();
        System.out.println("登录username=" + username + "，password=" + password + "，rememberMe=" + rememberMe);

        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);

        // 登录
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            // 更新用户登录时间，也可以在ShiroRealm里面做
            session.setAttribute("user", user);
            modelMap.addAttribute("user", user);
//            modelMap.put("msg", "0");
//            return "redirect:/";
            return ReturnResult.success();
        } catch (UnknownAccountException e) {
            System.out.println("============用户名不存在");
//            modelMap.put("msg", "1");
//            e.printStackTrace();
//            return "login";
            return ReturnResult.error("用户名不存在");
        } catch (IncorrectCredentialsException e) {
//            modelMap.put("msg", "2");
//            System.out.println("===========密码错误");
//            e.printStackTrace();
//            return "login";
            return ReturnResult.error("密码错误");
        }
    }

    @GetMapping("/logout")
    public String logout() {
        // 获取subject
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }


}
