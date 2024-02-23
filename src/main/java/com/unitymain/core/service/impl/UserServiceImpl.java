package com.unitymain.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.unitymain.core.dao.SysOperateDao;
import com.unitymain.core.dao.SysUserDao;
import com.unitymain.core.dao.SysRoleDao;
import com.unitymain.core.entity.SysOperate;
import com.unitymain.core.entity.SysRole;
import com.unitymain.core.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <h2>用户权限获取类</h2>
 * @author UnityMain
 * @see #loadUserByUsername
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private SysRoleDao sysRoleDao;

    @Resource
    private SysOperateDao sysOperateDao;

    /**
     * 通过用户名获取用户的权限，用户信息的方法
     * @param username   用户名
     * @return  用户数据
     * @throws UsernameNotFoundException    用户名不存在异常类
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserDao.selectOne(
                new QueryWrapper<SysUser>()
                        .eq("username",username));
        List<GrantedAuthority> authorityList = new ArrayList<>();

        if(sysUser==null){
            return null;
        }
        List<SysOperate> sysOperates = sysOperateDao.queryOperateByUserId(sysUser.getId());
        List<SysRole> sysRoles = sysRoleDao.queryRoleByUserId(sysUser.getId());

        //每个用户都拥有一个匿名角色
        SysRole everyone = new SysRole();
        everyone.setRoleName("ROLE_ANONYMOUS");
        everyone.setId(sysUser.getId());
        sysRoles.add(everyone);

        for(SysOperate sysOperate : sysOperates){
            authorityList.add(new SimpleGrantedAuthority(sysOperate.getCode()));
        }
        for(SysRole sysRole : sysRoles){
            authorityList.add(new SimpleGrantedAuthority(sysRole.getRoleName()));
        }

        sysUser.setAuthorityList(authorityList);
        return sysUser;
    }



}
