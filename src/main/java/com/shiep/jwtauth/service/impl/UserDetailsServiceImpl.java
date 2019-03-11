package com.shiep.jwtauth.service.impl;

import com.shiep.jwtauth.entity.FXUser;
import com.shiep.jwtauth.entity.JwtAuthUser;
import com.shiep.jwtauth.repository.FXUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 16:26
 * @description: 实现UserDetailsService，从数据库中加载用户信息==》用户名、密码及角色名
 *
 *  Spring Security中进行身份验证的是AuthenticationManager接口，ProviderManager是它的一个默认实现，但它并不用来处理身份认证，
 *  而是委托给配置好的AuthenticationProvider，每个AuthenticationProvider会轮流检查身份认证。检查后或者返回Authentication对象或者抛出异常。
 *
 *  验证身份就是加载响应的UserDetails，看看是否和用户输入的账号、密码、权限等信息匹配。
 *  此步骤由实现AuthenticationProvider的DaoAuthenticationProvider（它利用UserDetailsService验证用户名、密码和授权）处理。
 *  包含 GrantedAuthority 的 UserDetails对象在构建 Authentication对象时填入数据。
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private FXUserRepository userRepository;

    /**
     * description: 通过用户名从数据库中读取该用户账户信息及权限信息
     *
     * @param userName 用户名
     * @return org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        FXUser user = userRepository.findByName(userName);
        if(user==null){
            // 实际当用户不存在时，应该页面显示错误信息，并跳转到登录界面
            throw new UsernameNotFoundException("该用户不存在！");
        }
        user.setRoles(userRepository.getRolesByUserName(userName));
        System.out.println("UserDetailsServiceImpl==>loadUserByUsername:"+user.toString());
        return new JwtAuthUser(user);
    }
}
