package com.shiep.jwtauth.model;

import lombok.Data;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 16:18
 * @description: 封装了用户登录时的信息
 */
@Data
public class LoginUser {
    private String username;
    private String password;
    private Boolean rememberMe;
}
