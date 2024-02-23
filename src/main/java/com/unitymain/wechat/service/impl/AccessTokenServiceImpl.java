package com.unitymain.wechat.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.unitymain.wechat.entity.request.WxGzhInfo;
import com.unitymain.wechat.entity.response.AccessToken;
import com.unitymain.wechat.service.AccessTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author UnityMain
 */
@Service("accessTokenService")
public class AccessTokenServiceImpl implements AccessTokenService {

    public final Logger logger = LoggerFactory.getLogger(AccessTokenServiceImpl.class);
    @Resource
    private WxGzhInfo wxGzhInfo;

    @Override
    public AccessToken getToken() {
        HttpRequest request = HttpRequest.get("https://api.weixin.qq.com/cgi-bin/token")
                .form(BeanUtil.beanToMap(wxGzhInfo));

        HttpResponse response = request.execute();
        String body = response.body();
        if(StrUtil.contains(body,"errcode")){
            logger.info(body);
            return null;
        }
        AccessToken accessToken = JSONUtil.toBean(body, AccessToken.class);
        return accessToken;
    }
}
