package com.unitymain.core.service;

import com.unitymain.core.entity.SysMenu;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 前端菜单(SysMenu)表服务接口
 *
 * @author UnityMain
 * @since 2022-02-07 14:21:38
 */
public interface SysMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysMenu queryById(Integer id);

    /**
     * 查询全部的菜单
     *
     * @return 实例对象
     */
    List<SysMenu> queryAllMenu();

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysMenu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    SysMenu insert(SysMenu sysMenu);

    /**
     * 修改数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    SysMenu update(SysMenu sysMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    void test();

    void test1(String name, long start, long end, long edd);

}