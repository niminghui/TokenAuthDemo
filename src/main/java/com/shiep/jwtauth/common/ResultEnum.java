package com.shiep.jwtauth.common;

import lombok.Getter;

/**
 * @author: 倪明辉
 * @date: 2019/3/7 17:13
 * @description: JWT认证==》认证结果的枚举类
 */
@Getter
public enum ResultEnum {

    /**
     * description: 认证结果状态码及信息
     *
     * @param null
     * @return
     */
    SUCCESS(101,"成功"),
    FAILURE(102,"失败"),
    USER_NEED_AUTHORITIES(201,"用户未登录"),
    USER_LOGIN_FAILED(202,"用户账号或密码错误"),
    USER_LOGIN_SUCCESS(203,"用户登录成功"),
    USER_NO_ACCESS(204,"用户无权访问"),
    USER_LOGOUT_SUCCESS(205,"用户登出成功"),
    TOKEN_IS_BLACKLIST(206,"此token为黑名单"),
    LOGIN_IS_OVERDUE(207,"登录已失效"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * description: 通过code返回message
     *
     * @param code
     * @return com.shiep.jwtauth.common.ResultEnum
     */
    public static ResultEnum parse(int code){
        ResultEnum[] values = values();
        for (ResultEnum value : values) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw  new RuntimeException("Unknown code of ResultEnum");
    }
}