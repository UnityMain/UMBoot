package com.unitymain.core.service;

import com.unitymain.core.bean.Result;

/**
 * @author UnityMain
 */
public interface LoginService {
    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    Result login(String username, String password);

    /**
     * 注销功能
     * @return 生成的JWT的token
     */
    String logout();
}
