package com.unitymain.core.component;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.unitymain.core.bean.Result;
import com.unitymain.core.entity.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义成功拦截器
 * @author UnityMain
 */
@Component
public class AdminSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        SysUser principal = (SysUser) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Set<String> roles = new HashSet<>();
        if (CollectionUtil.isNotEmpty(authorities)) {
            for (GrantedAuthority authority : authorities) {
                String roleName = authority.getAuthority();
                roles.add(roleName);
            }
        }

        JSONObject user = new JSONObject();
        user.putOnce("username",principal.getUsername());
        user.putOnce("id",principal.getId());

        JSONObject data = new JSONObject();
        data.putOnce("user",user);
        data.putOnce("role",roles);

        Result result =  Result.ok().body(data);

        JSONUtil.toJsonStr(result, response.getWriter());
    }
}
