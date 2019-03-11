package com.shiep.jwtauth.service.impl;

import com.shiep.jwtauth.entity.FXUser;
import com.shiep.jwtauth.repository.FXUserRepository;
import com.shiep.jwtauth.repository.FXUserRoleRepository;
import com.shiep.jwtauth.service.IFXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 15:01
 * @description: IFXUserService的实现类
 */
@Service
public class FXUserServiceImpl implements IFXUserService {

    @Autowired
    FXUserRepository userRepository;

    @Autowired
    private FXUserRoleRepository userRoleRepository;

    /**
     * description: 加密工具
     *
     * @param null
     * @return
     */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public FXUser findByUserName(String username) {
        return userRepository.findByName(username);
    }

    @Override
    public List<String> getRolesByUserName(String userName) {
        return userRepository.getRolesByUserName(userName);
    }

    @Override
    public FXUser insert(String userName, String password) {
        FXUser user = new FXUser();
        user.setName(userName);
        // 将密码加密后存入数据库
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        user.setRoles(roles);
        // 将用户信息存入FX_USER表中
        FXUser result = userRepository.save(user);
        if (result.getName()!=null){
            // 插入用户成功时生成用户的角色信息
            userRoleRepository.save(result.getName(),"ROLE_USER");
            result.setRoles(roles);
            return result;
        }
        return null;
    }


}
