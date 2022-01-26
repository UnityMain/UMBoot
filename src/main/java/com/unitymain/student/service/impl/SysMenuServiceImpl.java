package com.unitymain.student.service.impl;

import com.unitymain.student.entity.SysMenu;
import com.unitymain.student.dao.SysMenuDao;
import com.unitymain.student.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 前端菜单(SysMenu)表服务实现类
 *
 * @author UnityMain
 * @since 2022-01-25 15:14:18
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuDao sysMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysMenu queryById(Integer id) {
        return this.sysMenuDao.queryById(id);
    }

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    @Override
    public List<SysMenu> queryAllMenu() {
        return this.sysMenuDao.queryAllMenu();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysMenu> queryAllByLimit(int offset, int limit) {
        return this.sysMenuDao.queryAllByLimit(offset, limit);
    }



    /**
     * 新增数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenu insert(SysMenu sysMenu) {
        this.sysMenuDao.insert(sysMenu);
        return sysMenu;
    }

    /**
     * 修改数据
     *
     * @param sysMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SysMenu update(SysMenu sysMenu) {
        this.sysMenuDao.update(sysMenu);
        return this.queryById(sysMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysMenuDao.deleteById(id) > 0;
    }
}