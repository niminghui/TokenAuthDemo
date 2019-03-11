package com.shiep.jwtauth.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 14:38
 * @description: 数据库中FX_USER表的实体类
 */
@Data
@Entity
@Table(name = "FX_USER")
public class FXUser implements Serializable {
    private static final long serialVersionUID = 4517281710313312135L;

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id自增长
    private Integer id;

    @Column(name = "USER_NAME",nullable = false)
    private String name;

    @Column(name = "USER_PASSWORD",nullable = false)
    private String password;

    /**
     * @Transient 表明是临时字段,roles是该用户的角色列表
     */
    @Transient
    private List<String> roles;
}
