package com.unitymain.core.component;

import cn.hutool.json.JSONUtil;
import com.unitymain.core.bean.Result;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <h2>登录失败异常处理器</h2>
 * <p>登陆失败时将会调用该方法进行处理</p>
 * @author UnityMain
 * @see #onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)
 */
@Component
public class AdminAuthenticationFailHandler implements AuthenticationFailureHandler {

    /**
     * 该方法处理登陆失败的响应结果
     * @param request   客户端请求
     * @param response  服务器响应
     * @param exception 登陆失败的异常类
     * @throws IOException  输出流的异常类
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        Result r = Result.failed();
        if (exception instanceof LockedException) {
            r.setMsg("账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            r.setMsg("密码过期，请联系管理员!");
        } else if (exception instanceof AccountExpiredException) {
            r.setMsg("账户过期，请联系管理员!");
        } else if (exception instanceof DisabledException) {
            r.setMsg("账户被禁用，请联系管理员!");
        } else if (exception instanceof BadCredentialsException) {
            r.setMsg("用户名或者密码输入错误，请重新输入!");
        }else{
            r.setMsg(exception.getLocalizedMessage());
        }
        JSONUtil.toJsonStr(r, response.getWriter());
    }
}
