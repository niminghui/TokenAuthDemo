package com.shiep.jwtauth.handler;

import com.alibaba.fastjson.JSON;
import com.shiep.jwtauth.common.ResultEnum;
import com.shiep.jwtauth.common.ResultVO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 倪明辉
 * @date: 2019/3/7 15:18
 * @description: 用户未登录时返回给前端的数据
 */
public class UnAuthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
//        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        String reason = "统一处理，原因："+authException.getMessage();
//        response.getWriter().write(new ObjectMapper().writeValueAsString(reason));
        response.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_NEED_AUTHORITIES,false)));
    }
}
