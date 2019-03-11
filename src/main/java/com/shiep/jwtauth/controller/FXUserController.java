package com.shiep.jwtauth.controller;

import com.shiep.jwtauth.entity.FXUser;
import com.shiep.jwtauth.service.IFXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 15:05
 * @description:
 */
@RestController
@RequestMapping(path = "/user",produces = "application/json;charset=utf-8")
public class FXUserController {
    @Autowired
    IFXUserService userService;

    @GetMapping("/{userName}")
    public FXUser getUser(@PathVariable String userName){
        FXUser user = userService.findByUserName(userName);
        user.setRoles(userService.getRolesByUserName(userName));
        return user;
    }
}
