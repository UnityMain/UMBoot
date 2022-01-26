package com.unitymain.student.entity;

import java.io.Serializable;

/**
 * 后台接口操作权限(SysOperate)实体类
 *
 * @author UnityMain
 * @since 2022-01-20 17:36:00
 */
public class SysOperate implements Serializable {
    private static final long serialVersionUID = 101193034611698493L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 权限代码
    */
    private String code;
    /**
    * 操作名称
    */
    private String name;
    /**
    * 请求路径
    */
    private String url;
    /**
    * 上级权限ID
    */
    private Integer parentId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

}