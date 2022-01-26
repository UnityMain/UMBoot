package com.unitymain.student.component;

import cn.hutool.json.JSONUtil;
import com.unitymain.student.bean.Result;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败过滤器
 * @author UnityMain
 */
@Component
public class AdminAuthenticationFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        Result r = Result.failed();
        if (exception instanceof LockedException) {
            r.setError("账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            r.setError("密码过期，请联系管理员!");
        } else if (exception instanceof AccountExpiredException) {
            r.setError("账户过期，请联系管理员!");
        } else if (exception instanceof DisabledException) {
            r.setError("账户被禁用，请联系管理员!");
        } else if (exception instanceof BadCredentialsException) {
            r.setError("用户名或者密码输入错误，请重新输入!");
        }else{
            r.setError(exception.getLocalizedMessage());
        }
        JSONUtil.toJsonStr(r, response.getWriter());
    }
}
