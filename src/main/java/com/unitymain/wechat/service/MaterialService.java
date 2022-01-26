package com.unitymain.wechat.service;

import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;

/**
 * @author UnityMain
 */
public interface MaterialService {
    /**
     * 获取素材数量
     * @return
     */
    JSONObject getMaterialCount();

    /**
     * 获取素材列表
     * @return
     */
    JSONObject batchgetMaterial(String type,String offset,String count);

    /**
     * 获取素材
     * @return
     */
    HttpResponse getMaterial();
}
