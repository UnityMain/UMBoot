package com.unitymain.student.service.impl;

import com.unitymain.student.entity.SysArea;
import com.unitymain.student.dao.SysAreaDao;
import com.unitymain.student.service.SysAreaService;
import org.springframework.stereotype.Service;

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
}