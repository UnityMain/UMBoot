package com.unitymain.core.component;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.unitymain.core.service.impl.UserServiceImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * <h2>用户认证处理器</h2>
 * <p>校验密码，获取权限的方法处理</p>
 * <p>登陆流程：第 3 步</p>
 * @author UnityMain
 * @see #authenticate(Authentication)
 */
public class AdminAuthenticationProvider implements AuthenticationProvider {

    /**
     * 查询用户的操作类
     */
    @Resource
    private UserServiceImpl userService;

    /**
     * 验证密码的方法
     * @param authentication    用户表单的账号密码
     * @return  校验结果
     * @throws AuthenticationException  校验异常
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取前端表单中输入后返回的用户名、密码
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserDetails userInfo = userService.loadUserByUsername(userName);

        if(!StrUtil.equals(SecureUtil.md5(password),userInfo.getPassword())){
            throw new BadCredentialsException(" 密码错误！");
        }
        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }


}
