package com.unitymain.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 前端菜单(SysMenu)实体类
 *
 * @author UnityMain
 * @since 2022-02-07 14:21:36
 */
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 563289804346832218L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 菜单名称
    */
    private String name;
    /**
    * 权限唯一标识
    */
    private String code;
    /**
    * 父节点菜单
    */
    private Integer parent;
    /**
    * 菜单路由地址
    */
    private String path;
    /**
    * 组件位置
    */
    private String component;
    /**
    * 图片名称
    */
    private String icon;
    /**
     * 是否隐藏
     */
    private Boolean hidden;
}