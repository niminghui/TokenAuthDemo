package com.shiep.jwtauth.controller;

import com.shiep.jwtauth.entity.FXUser;
import com.shiep.jwtauth.service.IFXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 16:30
 * @description: 控制层
 */
@RestController
@RequestMapping(path = "/auth",produces = "application/json;charset=utf-8")
public class AuthController {

    @Autowired
    private IFXUserService userService;

    /**
     * description: 注册默认权限（ROLE_USER）用户
     *
     * @param registerUser
     * @return java.lang.String
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        String userName=registerUser.get("username");
        String password=registerUser.get("password");
        FXUser user=userService.insert(userName,password);
        if(user==null){
            return "新建用户失败";
        }
        return user.toString();
    }
}