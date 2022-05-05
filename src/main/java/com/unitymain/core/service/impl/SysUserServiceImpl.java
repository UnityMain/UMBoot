package com.unitymain.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unitymain.core.entity.SysUser;
import com.unitymain.core.dao.SysUserDao;
import com.unitymain.core.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author UnityMain
 * @since 2022-01-20 17:29:15
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao,SysUser> implements SysUserService {
}