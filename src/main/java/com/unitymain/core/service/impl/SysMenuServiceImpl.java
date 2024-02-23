package com.unitymain.core.service.impl;

import cn.hutool.core.lang.Console;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unitymain.core.dao.SysMenuMapper;
import com.unitymain.core.entity.SysMenu;
import com.unitymain.core.service.SysAreaService;
import com.unitymain.core.service.SysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 前端菜单(SysMenu)表服务实现类
 *
 * @author UnityMain
 * @since 2022-02-07 14:21:39
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> queryMenuByUsername(String username) {
        return sysMenuMapper.queryMenuByUsername(username);
    }
}