package com.unitymain.student.filter;

import cn.hutool.core.util.StrUtil;
import com.unitymain.student.dao.SysOperateDao;
import com.unitymain.student.entity.SysOperate;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 权限查询器
 * @author UnityMain
 */
@Component
public class AdminFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    private SysOperateDao sysOperateDao;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        String httpMethod = fi.getRequest().getMethod();

        List<ConfigAttribute> attributes = new ArrayList<>();

        List<SysOperate> sysOperates = sysOperateDao.queryAll(null);
        for(SysOperate sysOperate : sysOperates){
            if(antPathMatcher.match(sysOperate.getUrl(),url)){
                return SecurityConfig.createList(sysOperate.getUrl());
            }
        }
        // 返回null和空列表是一样的，都表示当前访问的资源不需要权限，所有人都可以访问
        return SecurityConfig.createList("ROLE_ANONYMOUS");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
