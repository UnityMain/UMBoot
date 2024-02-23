package com.unitymain.core.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.unitymain.core.component.AdminAuthenticationFailHandler;
import com.unitymain.core.component.AdminSuccessHandler;
import com.unitymain.core.component.CustAuthenticationManager;
import com.unitymain.core.entity.SysUser;
import com.unitymain.core.entity.ValidateCode;
import com.unitymain.core.service.impl.UserServiceImpl;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 自定义用户密码校验过滤器
 * <p>登陆流程：第 1 步</p>
 *
 * @author unitymain
 */
//@Component
public class AdminAuthenticationProcessingFilter extends UsernamePasswordAuthenticationFilter {

    @Resource
    private UserServiceImpl userService;

    public AdminAuthenticationProcessingFilter(CustAuthenticationManager custAuthenticationManager, AdminSuccessHandler adminSuccessHandler, AdminAuthenticationFailHandler adminAuthenticationFailHandler) {
        this.setAuthenticationSuccessHandler(adminSuccessHandler);
        this.setAuthenticationFailureHandler(adminAuthenticationFailHandler);
        this.setAuthenticationManager(custAuthenticationManager);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        UsernamePasswordAuthenticationToken autoToken;
        String body = ServletUtil.getBody(request);
        JSONObject json = null;
        try {
            json = JSONUtil.parseObj(body);
        } catch (JSONException e) {
            throw new AuthenticationServiceException("请求不是json传输");
        }
        String username = json.getStr("username");
        String password = json.getStr("password");
        HttpSession session = request.getSession();
        ValidateCode validateCode = (ValidateCode)session.getAttribute("validateCode");
        String requestCode = json.getStr("validateCode");
        if(StrUtil.isEmpty(requestCode)){
            throw new AuthenticationServiceException("验证码不能为空");
        }
        if(validateCode==null){
            throw new AuthenticationServiceException("请先获取验证码");
        }
        if(!StrUtil.equals(validateCode.getCode(),requestCode)){
            throw new AuthenticationServiceException("验证码不正确");
        }
        UserDetails userDetails = userService.loadUserByUsername(username);
        autoToken = new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
        autoToken.setDetails(userDetails);

        return this.getAuthenticationManager().authenticate(autoToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(authResult.getName());
        super.successfulAuthentication(request, response, chain, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
