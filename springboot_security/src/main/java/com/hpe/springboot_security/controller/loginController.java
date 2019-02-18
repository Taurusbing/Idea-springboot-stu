package com.hpe.springboot_security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class loginController {
    private Logger logger = LoggerFactory.getLogger(loginController.class);

    @GetMapping("/")
    public String showHome() {
        //获取当前登录用户
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登录用户：{}", name);
        return "home.html";
    }

    @GetMapping("/login")
    public String showLogin(){
        return "login.html";
    }

    @GetMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin(){
        return "如果你看见这句话，说明你有ROLE_Admin角色";
    }

    @GetMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser(){
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }

}
