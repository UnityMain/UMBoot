package com.unitymain.core.component;

import cn.hutool.json.JSONUtil;
import com.unitymain.core.bean.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <h2>无权限异常处理器</h2>
 * <p>登录用户如果没有限访问则会调用到该方法</p>
 * @author UnityMain
 * @see #handle(HttpServletRequest, HttpServletResponse, AccessDeniedException)
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    /**
     * 处理无权限异常
     * @param request   客户端请求类
     * @param response  服务器响应类
     * @param accessDeniedException 无权限异常信息类
     * @throws IOException  输出流异常
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        Result<String> result = Result.failed("没有访问权限!");
        JSONUtil.toJsonStr(result,response.getWriter());
    }
}
