package com.unitymain.core.service.impl;

import com.unitymain.core.entity.SysOperate;
import com.unitymain.core.dao.SysOperateDao;
import com.unitymain.core.service.SysOperateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台接口操作权限(SysOperate)表服务实现类
 *
 * @author UnityMain
 * @since 2022-01-20 17:36:00
 */
@Service("sysOperateService")
public class SysOperateServiceImpl implements SysOperateService {
    @Resource
    private SysOperateDao sysOperateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysOperate queryById(Integer id) {
        return this.sysOperateDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SysOperate> queryAllByLimit(int offset, int limit) {
        return this.sysOperateDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysOperate 实例对象
     * @return 实例对象
     */
    @Override
    public SysOperate insert(SysOperate sysOperate) {
        this.sysOperateDao.insert(sysOperate);
        return sysOperate;
    }

    /**
     * 修改数据
     *
     * @param sysOperate 实例对象
     * @return 实例对象
     */
    @Override
    public SysOperate update(SysOperate sysOperate) {
        this.sysOperateDao.update(sysOperate);
        return this.queryById(sysOperate.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysOperateDao.deleteById(id) > 0;
    }
}