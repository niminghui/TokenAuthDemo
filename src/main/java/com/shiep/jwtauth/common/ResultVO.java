package com.shiep.jwtauth.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 倪明辉
 * @date: 2019/3/7 17:23
 * @description: response返回结果集
 */
public class ResultVO implements Serializable {
    private static final long serialVersionUID = -5359028332240046810L;

    /**
     * description: 返回响应信息
     *
     * @param respCode
     * @param success
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> result(ResultEnum respCode, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", respCode.getCode());
        map.put("message", respCode.getMessage());
        map.put("data", null);
        map.put("success",success);
        return map;
    }

    /**
     * description: 返回响应信息及Token
     *
     * @param respCode
     * @param jwtToken
     * @param success
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public final static Map<String, Object> result(ResultEnum respCode, String jwtToken, Boolean success) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jwtToken",jwtToken);
        map.put("code", respCode.getCode());
        map.put("message", respCode.getMessage());
        map.put("data", null);
        map.put("success",success);
        return map;
    }
}
