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
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Collection;

/**
 * 自定义认证处理
 * @author UnityMain
 */
@Component
public class AdminAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private UserServiceImpl userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取前端表单中输入后返回的用户名、密码
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserDetails userInfo = userService.loadUserByUsername(userName);

        if(!StrUtil.equals(SecureUtil.md5(password),userInfo.getPassword())){
            throw new BadCredentialsException("密码错误！");
        }
        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }


}
