package com.shiep.jwtauth.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: 倪明辉
 * @date: 2019/3/6 16:53
 * @description: 数据库中FX_USER_ROLE表的实体类
 */
@Data
@Entity
@Table(name = "FX_USER_ROLE")
@IdClass(FXUserRole.class)
public class FXUserRole implements Serializable {
    private static final long serialVersionUID = 6746672328835480737L;
    @Id
    @Column(name = "USER_ID",nullable = false)
    private Integer userId;

    @Id
    @Column(name = "ROLE_ID",nullable = false)
    private Integer roleId;
}
