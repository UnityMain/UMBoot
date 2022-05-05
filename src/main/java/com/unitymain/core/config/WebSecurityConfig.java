package com.unitymain.core.config;

import com.unitymain.core.component.*;
import com.unitymain.core.filter.AdminAuthenticationProcessingFilter;
import com.unitymain.core.filter.AdminFilterSecurityMetadataSource;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * security配置文件
 *
 * @author unitymain
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private AdminFilterSecurityMetadataSource adminFilterSecurityMetadataSource;
    @Resource
    private AdminAccessDecisionManager adminAccessDecisionManager;
    @Resource
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Resource
    private AdminAuthenticationEntryPoint adminAuthenticationEntryPoint;
    @Resource
    private AdminLogoutSuccessHandler adminLogoutSuccessHandler;
    @Resource
    private AdminAuthenticationProcessingFilter adminAuthenticationProcessingFilter;


    /**
     * 地址拦截配置规则
     * anyRequest          |   匹配所有请求路径
     * access              |   SpringEl表达式结果为true时可以访问
     * anonymous           |   匿名可以访问
     * denyAll             |   用户不能访问
     * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
     * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
     * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
     * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
     * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
     * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
     * permitAll           |   用户可以任意访问
     * rememberMe          |   允许通过remember-me登录的用户访问
     * authenticated       |   用户登录后可访问
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //表单登录方式
        http.formLogin()
                .loginPage("/login")
                .permitAll()
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(adminLogoutSuccessHandler)
                //自定义拦截
                .and().authorizeRequests()
                //屏蔽一些错误
                .antMatchers("/error/**").permitAll()
                .anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        // 权限查询器
                        object.setSecurityMetadataSource(adminFilterSecurityMetadataSource);
                        // 权限决策器
                        object.setAccessDecisionManager(adminAccessDecisionManager);
                        return object;
                    }
                })
                //登录异常拦截
                .and().exceptionHandling()
                // 认证失败处理类
                .authenticationEntryPoint(adminAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler)

                //解决csrf不支持post请求的问题
                .and().csrf().disable();

        //自定义登录认证的功能
        http.addFilterAt(adminAuthenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/image/**","/css/**");
    }
}
