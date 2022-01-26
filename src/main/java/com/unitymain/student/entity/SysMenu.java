package com.unitymain.student.entity;

import java.io.Serializable;

/**
 * 前端菜单(SysMenu)实体类
 *
 * @author UnityMain
 * @since 2022-01-25 15:14:18
 */
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 222234519175068494L;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

}