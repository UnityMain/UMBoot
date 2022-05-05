package com.unitymain.core.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 验证码的实体类
 * @author UnityMain
 */
@Data
public class ValidateCode implements Serializable {
    @Serial
    private static final long serialVersionUID = -6868563888226660464L;

    /**
     * 上次获取验证码的时间
     */
   private Long lastTime;
    /**
     * 验证码
     */
   private String code;
}
