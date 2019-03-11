package com.shiep.jwtauth.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 15:27
 * @description: 实现UserDetails，封装用户信息，用于验证身份
 */
public class JwtAuthUser implements UserDetails {
    private Integer id;
    private String userName;
    private String password;
    private List<String> roles;
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * description: 通过FXUser来创建JwtAuthUser
     *
     * @param user
     * @return
     */
    public JwtAuthUser(FXUser user){
        this.id=user.getId();
        this.userName=user.getName();
        this.password=user.getPassword();
        this.roles=user.getRoles();
    }

    /**
     * description: 鉴权最重要方法，通过此方法来返回用户权限
     *
     * @param
     * @return java.util.Collection<? extends org.springframework.security.core.GrantedAuthority>
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        if (roles!=null) {
            for (String role : roles) {
                authorities.add(new SimpleGrantedAuthority(role));
            }
        }
        System.out.println("authorities:"+authorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "JwtAuthUser{" +
                "id=" + id +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + roles +
                '}';
    }
}
