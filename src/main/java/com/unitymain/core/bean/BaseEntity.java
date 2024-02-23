package com.unitymain.core.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * 基础实体类
 * @author UnityMain
 */
@Data
@JsonIgnoreProperties(allowSetters=true,value = {"size","current","page"})
public class BaseEntity {
    @TableField(exist = false)
    private long size;
    @TableField(exist = false)
    private long current;

    /**
     * 返回一个分页参数
     * @return
     */
    public Page getPage(){
        return new Page<>(current, size);
    }
}
