package com.shiep.jwtauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: 倪明辉
 * @date: 2019/3/8 10:31
 * @description:
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String toLoginPage(){
        return "loginPage";
    }

    @GetMapping("/home")
    public String toHomePage(){
        return "homePage";
    }
}
