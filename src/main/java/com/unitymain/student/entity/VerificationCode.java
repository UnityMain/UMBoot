package com.unitymain.student.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class VerificationCode implements Serializable {
    /**
     * 上次获取验证码的时间
     */
   private Long lastTime;
    /**
     * 验证码
     */
   private String code;
}
