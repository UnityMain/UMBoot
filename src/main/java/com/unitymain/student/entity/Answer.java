package com.unitymain.student.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Answer)实体类
 *
 * @author makejava
 * @since 2020-07-22 18:42:31
 */
@Data
public class Answer implements Serializable {
    private static final long serialVersionUID = -86832979133059138L;
    /**
    * 答案ID
    */
    private Integer id;
    /**
    * 答案编号
    */
    private String num;
    /**
    * 答案内容
    */
    private String content;
    /**
    * 问题ID
    */
    private Integer questionId;
    private Boolean isActive = false;

}