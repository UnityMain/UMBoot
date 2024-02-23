package com.unitymain.core.filter;

import com.unitymain.core.dao.SysOperateDao;
import com.unitymain.core.entity.SysOperate;
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

/**
 * <h2>权限搜索器</h2><p>
 * 通过url路径和数据库路径进行比较，将访问该路径所需权限添加进来<p>
 * @author UnityMain
 * @see #getAttributes(Object)
 */
@Component
public class AdminFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    /**
     * 用于查询全部的操作权限
     */
    @Resource
    private SysOperateDao sysOperateDao;

    /**
     * spring默认使用的规则匹配器
     * <ul>
     *     <li>? 匹配一个字符</li>
     *     <li>* 匹配0个及以上字符</li>
     *     <li>** 匹配0个及以上目录</li>
     * </ul>
     */
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();


    /**
     * 该方法用于获取url所需权限<p>
     *
     * @param object 用户请求的属性
     * @return 该url所需权限
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object){
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        List<ConfigAttribute> attributes = new ArrayList<>();
        //与数据库的角色权限联系起来
        List<SysOperate> sysOperates = sysOperateDao.queryAll(null);
        for(SysOperate sysOperate : sysOperates){
            //比较数据库配置的地址和请求URL是否是包含关系
            if(antPathMatcher.match(sysOperate.getUrl(),url)){
                ConfigAttribute configAttribute = new SecurityConfig(sysOperate.getCode());
                attributes.add(configAttribute);
            }
        }
        return attributes;
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
