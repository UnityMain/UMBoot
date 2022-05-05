package com.unitymain.core.service.impl;

import cn.hutool.core.lang.Console;
import com.unitymain.core.entity.SysMenu;
import com.unitymain.core.dao.SysMenuDao;
import com.unitymain.core.service.SysAreaService;
import com.unitymain.core.service.SysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * 前端菜单(SysMenu)表服务实现类
 *
 * @author UnityMain
 * @since 2022-02-07 14:21:39
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuDao sysMenuDao;

    @Resource
    private SysAreaService sysAreaService;

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void test(){
        for(int i=0;i<20;i++){
            int finalI = i;

        }
        new Thread(() ->{
            sysAreaService.test1("ceshi"+ 1,200,500,100);
        }).start();

        new Thread(() ->{
            sysAreaService.test1("ceshi"+ 2,300,300,200);
        }).start();
        Console.log("卧槽卧槽");
    }

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public void test1(String name, long start, long end,long edd){
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