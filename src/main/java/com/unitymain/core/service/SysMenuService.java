package com.unitymain.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.unitymain.core.entity.SysMenu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 前端菜单(SysMenu)表服务接口
 *
 * @author UnityMain
 * @since 2022-02-07 14:21:38
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 查询全部的菜单
     * @param username 用户名
     * @return 实例对象
     */
    List<SysMenu> queryMenuByUsername(String username);

}