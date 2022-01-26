package com.unitymain.student.service.impl;

import com.unitymain.student.dao.SysOperateDao;
import com.unitymain.student.dao.SysUserDao;
import com.unitymain.student.dao.SysRoleDao;
import com.unitymain.student.entity.SysOperate;
import com.unitymain.student.entity.SysRole;
import com.unitymain.student.entity.SysUser;
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
        SysUser sysUser = sysUserDao.queryByUsername(username);
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
