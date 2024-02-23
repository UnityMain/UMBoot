package com.unitymain.core.component;

import cn.hutool.core.util.StrUtil;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * <h2>权限决策器</h2>
 * <p>用户权限和URL权限如何进行判断的处理器</p>
 * @author UnityMain
 * @see #decide(Authentication, Object, Collection)
 */
@Component
public class AdminAccessDecisionManager implements AccessDecisionManager {

    /**
     * 该地方只做两个权限是否是同一个字符串的判断
     * @param authentication    当前登录人的角色或者权限
     * @param object            当前请求的地址和方式
     * @param configAttributes  当前路径需要的角色或者权限
     * @throws AccessDeniedException    权限不足的异常
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        // 查看当前用户是否有对应的权限访问该保护资源
        for (ConfigAttribute attribute : configAttributes) {
            for (GrantedAuthority authority : authorities) {
                //当只要自己拥有当权限命中1次，就当拥有该权限
                if (StrUtil.equals(authority.getAuthority(),attribute.getAttribute())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("Access is denied");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
