package com.unitymain.wechat.entity.common;

import lombok.Data;

@Data
public class WxStatus {
    /**
     *  错误码
     */
    private String errcode;
    /**
     *  错误信息
     */
    private String errmsg;
}
