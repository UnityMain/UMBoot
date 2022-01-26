package com.unitymain.student.service;

import com.unitymain.student.entity.SysOperate;
import java.util.List;

/**
 * 后台接口操作权限(SysOperate)表服务接口
 *
 * @author UnityMain
 * @since 2022-01-20 17:36:00
 */
public interface SysOperateService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysOperate queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysOperate> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysOperate 实例对象
     * @return 实例对象
     */
    SysOperate insert(SysOperate sysOperate);

    /**
     * 修改数据
     *
     * @param sysOperate 实例对象
     * @return 实例对象
     */
    SysOperate update(SysOperate sysOperate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}