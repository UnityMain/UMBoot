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
 * 用户登录service
 * @author UnityMain
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private SysRoleDao sysRoleDao;

    @Resource
    private SysOperateDao sysOperateDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserDao.selectOne(
                new QueryWrapper<SysUser>()
                        .eq("username",username));
        List<GrantedAuthority> authorityList = new ArrayList<>();
        List<SysOperate> sysOperates = sysOperateDao.queryOperateByUserId(sysUser.getId());
        List<SysRole> sysRoles = sysRoleDao.queryRoleByUserId(sysUser.getId());

        for(SysOperate sysOperate : sysOperates){
            authorityList.add(new SimpleGrantedAuthority(sysOperate.getUrl()));
        }
        for(SysRole sysRole : sysRoles){
            authorityList.add(new SimpleGrantedAuthority(sysRole.getRoleName()));
        }

        sysUser.setAuthorityList(authorityList);
        return sysUser;
    }



}
