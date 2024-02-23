package com.unitymain.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unitymain.core.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色表(SysRole)表数据库访问层
 *
 * @author UnityMain
 * @since 2022-01-20 17:16:39
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRole> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysRole queryById(Integer id);

    /**
     * 通过userId查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    List<SysRole> queryRoleByUserId(Integer userId);

    /**
     * 通过用户id查找角色列表
     *
     * @param userId 用户ID
     * @return 实例对象
     */
    List<SysRole> findByUserId(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRole 实例对象
     * @return 对象列表
     */
    List<SysRole> queryAll(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 影响行数
     */
    int update(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}