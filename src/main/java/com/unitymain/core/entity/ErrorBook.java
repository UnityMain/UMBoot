package com.unitymain.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (ErrorBook)实体类
 *
 * @author makejava
 * @since 2020-07-22 18:48:52
 */
@Data
public class ErrorBook implements Serializable {
    private static final long serialVersionUID = -36523392374039550L;
    /**
    * 问题ID
    */
    private Integer id;
    /**
    * 题目内容
    */
    private String subject;
    /**
    * 解析内容
    */
    private String solution;
    /**
    * 题目附图
    */
    private Byte[] image;
    /**
    * 题目一级类型
    */
    private String type;
    /**
    * 题目二级类型
    */
    private String questionType;
    /**
    * 正确答案
    */
    private String answerTrue;

}