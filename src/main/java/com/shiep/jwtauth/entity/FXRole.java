package com.shiep.jwtauth.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 15:31
 * @description: 映射数据库中的FX_ROLE角色表
 */
@Data
@Entity
@Table(name = "FX_ROLE")
public class FXRole implements Serializable {
    private static final long serialVersionUID = -3112666718610962186L;

    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id自增长
    private Integer id;

    @Column(name = "ROLE_NAME",nullable = false)
    private String name;
}
