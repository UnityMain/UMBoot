package com.unitymain.core.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author UnityMain
 */
@Data
public class LoginDto implements Serializable {
    private static final long serialVersionUID = -7222640938931579576L;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String validateCode;
}
