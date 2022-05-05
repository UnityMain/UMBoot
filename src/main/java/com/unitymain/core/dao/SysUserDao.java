package com.unitymain.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unitymain.core.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author UnityMain
 * @since 2022-01-20 17:29:10
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {
}