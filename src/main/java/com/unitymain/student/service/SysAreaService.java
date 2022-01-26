package com.unitymain.student.service;

import com.unitymain.student.entity.SysArea;
import java.util.List;

/**
 * 地区表(SysArea)表服务接口
 *
 * @author makejava
 * @since 2020-09-26 18:46:51
 */
public interface SysAreaService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysArea queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysArea> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysArea 实例对象
     * @return 实例对象
     */
    SysArea insert(SysArea sysArea);

    /**
     * 修改数据
     *
     * @param sysArea 实例对象
     * @return 实例对象
     */
    SysArea update(SysArea sysArea);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}