package com.unitymain.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unitymain.core.entity.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 前端菜单(SysMenu)表数据库访问层
 *
 * @author UnityMain
 * @since 2022-02-07 14:21:37
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 通过用户名查询拥有的菜单列表
     * @param username  用户名
     * @return  菜单列表
     */
    List<SysMenu> queryMenuByUsername(@Param("username") String username);
}