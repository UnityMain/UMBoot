package com.unitymain.student.component;

import cn.hutool.json.JSONUtil;
import com.unitymain.student.bean.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注销成功后的过滤器
 * @author UnityMain
 */
@Component
public class AdminLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        JSONUtil.toJsonStr(Result.ok("注销成功"),response.getWriter());
    }
}
