package com.unitymain.core.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (QuestionType)实体类
 *
 * @author makejava
 * @since 2020-07-22 23:27:28
 */
@Data
public class QuestionType implements Serializable {
    private static final long serialVersionUID = 335305569919765497L;
    
    private Integer id;
    
    private String label;
    
    private Integer parentId;


}