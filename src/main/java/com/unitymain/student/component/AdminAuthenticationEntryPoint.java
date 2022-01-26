package com.unitymain.student.component;

import cn.hutool.json.JSONUtil;
import com.unitymain.student.bean.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 匿名用户访问没权限的地址
 * @author UnityMain
 */
@Component
public class AdminAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        JSONUtil.toJsonStr(Result.failed("尚未登录，请先登录"),response.getWriter());
    }
}
