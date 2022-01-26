package com.unitymain.wechat.entity.request;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author unitymain
 */

@Component
@Data
@PropertySource(value = {"classpath:config_base.properties"})
@ConfigurationProperties(prefix = "wx")
public class WxGzhInfo {
    /**
     * 获取access_token填写client_credential
     */
    private String grant_type = "client_credential";
    /**
     * 第三方用户唯一凭证
     */
    private String appid;
    /**
     * secret
     */
    private String secret;
}
