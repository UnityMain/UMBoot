package com.unitymain.student.dao;

import com.unitymain.student.entity.SysOperate;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 后台接口操作权限(SysOperate)表数据库访问层
 *
 * @author UnityMain
 * @since 2022-01-20 17:36:00
 */
@Mapper
public interface SysOperateDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysOperate queryById(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    List<SysOperate> queryOperateByUserId(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysOperate> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysOperate 实例对象
     * @return 对象列表
     */
    List<SysOperate> queryAll(SysOperate sysOperate);

    /**
     * 新增数据
     *
     * @param sysOperate 实例对象
     * @return 影响行数
     */
    int insert(SysOperate sysOperate);

    /**
     * 修改数据
     *
     * @param sysOperate 实例对象
     * @return 影响行数
     */
    int update(SysOperate sysOperate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}