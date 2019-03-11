package com.shiep.jwtauth.handler;

import com.alibaba.fastjson.JSON;
import com.shiep.jwtauth.common.ResultEnum;
import com.shiep.jwtauth.common.ResultVO;
import com.shiep.jwtauth.entity.JwtAuthUser;
import com.shiep.jwtauth.utils.JwtTokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: 倪明辉
 * @date: 2019/3/8 10:07
 * @description:
 */
public class FxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        JwtAuthUser userDetails = (JwtAuthUser) authentication.getPrincipal();

        //String jwtToken = JwtTokenUtils.createToken(userDetails.getUsername(),userDetails.getAuthorities(),1);

        //httpServletResponse.getWriter().write(JSON.toJSONString(ResultVO.result(ResultEnum.USER_LOGIN_SUCCESS,jwtToken,true)));
    }
}
