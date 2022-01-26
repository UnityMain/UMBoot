package com.unitymain.wechat.entity.response;

import lombok.Data;

/**
 * @author UnityMain
 */
@Data
public class AccessToken {
    private String access_token;
    private String expires_in;
}
