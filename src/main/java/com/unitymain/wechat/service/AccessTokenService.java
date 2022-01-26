package com.unitymain.wechat.service;


import com.unitymain.student.bean.Result;
import com.unitymain.wechat.entity.response.AccessToken;

/**
 * 获取accessToken
 * @author unitymain
 */
public interface AccessTokenService {
    /**
     * 向微信
     * @return
     */
    AccessToken getToken();
}
