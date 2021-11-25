package com.unitymain.student.entity;

import cn.hutool.core.annotation.PropIgnore;
import lombok.Data;
import java.util.Date;
import java.io.Serializable;

/**
 * (Position)实体类
 *
 * @author makejava
 * @since 2020-09-25 22:19:17
 */
@Data
public class Position implements Serializable {
    private static final long serialVersionUID = 517962887420538793L;
    /**
    * 单位ID主键
    */
    @PropIgnore
    private Integer id;
    /**
    * 单位所属地区
    */
    private String fromArea;
    /**
    * 单位代码编号
    */
    private String unitCode;
    /**
    * 单位性质
    */
    private String unitType;
    /**
    * 单位名称
    */
    private String unitName;
    /**
    * 单位性质
    */
    private String unitNature;
    /**
    * 岗位代码编号
    */
    private String jobCode;
    /**
    * 岗位名称
    */
    private String jobName;
    /**
    * 岗位类别
    */
    private String jobType;
    /**
    * 岗位描述
    */
    private String jobDesc;
    /**
    * 招聘人数
    */
    private Integer number;
    /**
    * 考试类别
    */
    private String examType;
    /**
    * 要求学历
    */
    private String education;
    /**
    * 要求学位
    */
    private String degree;
    /**
    * 中专专业
    */
    private String zhongzhuanZy;
    /**
    * 大专专业
    */
    private String dazhuanZy;
    /**
    * 本科专业
    */
    private String benkeZy;
    /**
    * 研究生专业
    */
    private String yanjiushengZy;
    /**
    * 其他要求
    */
    private String otherDemand;
    /**
    * 报名时间
    */
    private Date enrollDate;
    /**
    * 截止时间
    */
    private Date endDate;
    /**
    * 备注
    */
    private String remarks;


}