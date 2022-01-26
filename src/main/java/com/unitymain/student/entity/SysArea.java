package com.unitymain.student.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 地区表(SysArea)实体类
 *
 * @author makejava
 * @since 2020-09-26 18:46:50
 */
@Data
public class SysArea implements Serializable {
    private static final long serialVersionUID = -30300834636240315L;
    /**
    * 主键
    */
    private String id;
    /**
    * 行政地区编号
    */
    private String code;
    /**
    * 地区名称
    */
    private String name;
    /**
    * 地区缩写
    */
    private String shortName;
    /**
    * 地区父id
    */
    private String parentId;
    /**
    * 地区级别 1-省、自治区、直辖市 2-地级市、地区、自治州、盟 3-市辖区、县级市、县
    */
    private Integer level;
    /**
    * 经度
    */
    private String longitude;
    /**
    * 纬度
    */
    private String latitude;

}