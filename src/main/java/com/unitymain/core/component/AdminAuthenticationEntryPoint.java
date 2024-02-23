package com.unitymain.core.component;

import cn.hutool.json.JSONUtil;
import com.unitymain.core.bean.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <h2>匿名用户权限处理器</h2>
 * <p>当匿名用户访问没权限的地址时，处理返回结果的方法</p>
 * @author UnityMain
 * @see #commence(HttpServletRequest, HttpServletResponse, AuthenticationException)
 */
@Component
public class AdminAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /**
     * 处理匿名用户访问权限地址的方法
     * @param request   客户端请求
     * @param response  服务器响应
     * @param authException 认证异常类
     * @throws IOException  输出异常类
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        JSONUtil.toJsonStr(Result.failed("尚未登录，请先登录"),response.getWriter());
    }
}
