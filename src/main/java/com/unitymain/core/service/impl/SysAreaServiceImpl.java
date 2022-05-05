package com.unitymain.core.service.impl;

import cn.hutool.core.lang.Console;
import com.unitymain.core.dao.SysMenuDao;
import com.unitymain.core.entity.SysArea;
import com.unitymain.core.dao.SysAreaDao;
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
 * 地区表(SysArea)表服务实现类
 *
 * @author makejava
 * @since 2020-09-26 18:46:52
 */
@Service("sysAreaService")
public class SysAreaServiceImpl implements SysAreaService {

    @Resource
    private SysAreaDao sysAreaDao;

    @Resource
    private SysMenuDao sysMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysArea queryById(String id) {
        return this.sysAreaDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysArea> queryAllByLimit(int offset, int limit) {
        return this.sysAreaDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysArea 实例对象
     * @return 实例对象
     */
    @Override
    public SysArea insert(SysArea sysArea) {
        this.sysAreaDao.insert(sysArea);
        return sysArea;
    }

    /**
     * 修改数据
     *
     * @param sysArea 实例对象
     * @return 实例对象
     */
    @Override
    public SysArea update(SysArea sysArea) {
        this.sysAreaDao.update(sysArea);
        return this.queryById(sysArea.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.sysAreaDao.deleteById(id) > 0;
    }

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_UNCOMMITTED)
    @Override
    public void test1(String name, long start, long end, long edd){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(30);
        sysMenu.setName(name);
        try {
            Thread.sleep(start);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SysMenu sysMenuOld = this.sysMenuDao.queryById(30);
        Console.log("旧:{},{}",sysMenuOld.getName(),Thread.currentThread().getId());
        this.sysMenuDao.update(sysMenu);
        try {
            Thread.sleep(end);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SysMenu sysMenuNew = this.sysMenuDao.queryById(30);
        Console.log("新:{},{}",sysMenuNew.getName(),Thread.currentThread().getId());
        try {
            Thread.sleep(edd);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}