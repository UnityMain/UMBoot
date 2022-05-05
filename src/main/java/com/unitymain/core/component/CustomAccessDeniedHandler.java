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
 * 登录用户无权限访问的地址
 * @author UnityMain
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        Result<String> result = Result.failed("没有访问权限!");
        JSONUtil.toJsonStr(result,response.getWriter());
    }
}
