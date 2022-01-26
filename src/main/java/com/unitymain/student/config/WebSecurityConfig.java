package com.unitymain.student.config;

import com.unitymain.student.component.*;
import com.unitymain.student.filter.AdminAuthenticationProcessingFilter;
import com.unitymain.student.filter.AdminFilterSecurityMetadataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
     * 配置SpringSecurity相关信息
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
                .authenticationEntryPoint(adminAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler)

                //防止get请求走权限
                .and().csrf().disable();

        //自定义登录认证的功能
        http.addFilterAt(adminAuthenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/image/**","/css/**");
    }
}
