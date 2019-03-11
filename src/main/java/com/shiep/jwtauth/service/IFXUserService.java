package com.shiep.jwtauth.service;

import com.shiep.jwtauth.entity.FXUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 15:00
 * @description: FXUser的Service接口
 */
@Transactional(rollbackFor = Exception.class)
public interface IFXUserService {
    /**
     * description: 通过用户名查找用户
     *
     * @param username
     * @return com.shiep.jwtauth.entity.FXUser
     */
    FXUser findByUserName(String username);

    /**
     * description: 通过用户名得到角色列表
     *
     * @param userName
     * @return java.lang.String
     */
    List<String> getRolesByUserName(String userName);

    /**
     * description: 通过用户名密码创建用户，默认角色为ROLE_USER
     *
     * @param userName
     * @param password
     * @return com.shiep.jwtauth.entity.FXUser
     */
    FXUser insert(String userName,String password);
}
