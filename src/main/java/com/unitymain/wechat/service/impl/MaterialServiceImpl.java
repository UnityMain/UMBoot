package com.unitymain.wechat.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.unitymain.wechat.service.MaterialService;
import org.springframework.stereotype.Service;

/**
 * @author UnityMain
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    private String token = "52_L-DBMalzbhZAM6WMvLxkRmQtd_3UDfq9S9dvzpn4d4Ayskch5a1Qmzvt5tgmj5CKdzztBRa0UxUR6ZNXesM4nYR42KZe3Uux2Xt_ZlBiEdfbl96_ixZGb-2kcCfPrWDG2HWndtjDJLjuAyZSZYUcAHAQPL";

    /**
     * 获取素材数量
     * @return
     */
    @Override
    public JSONObject getMaterialCount() {
        HttpRequest request = HttpRequest.get("https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token="+token);
        HttpResponse response = request.execute();
        String body = response.body();
        JSONObject jsonObject = JSONUtil.parseObj(body);
        return jsonObject;
    }

    /**
     * 获取素材列表
     * @return
     */
    @Override
    public JSONObject batchgetMaterial(String type,String offset,String count){
        JSONObject json = JSONUtil.createObj();
        json.putOnce("type",type);
        json.putOnce("offset",offset);
        json.putOnce("count",count);
        HttpRequest request = HttpRequest.post("https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token="+token)
                .body(json.toString());

        HttpResponse response = request.execute();
        String body = response.body();
        JSONObject jsonObject = JSONUtil.parseObj(body);
        return jsonObject;
    }

    /**
     * 获取素材
     * @return
     */
    @Override
    public HttpResponse getMaterial(){
        JSONObject json = JSONUtil.createObj();
        json.putOnce("media_id","tNbGpwDXOUEqWTJEd6Tg4T19lpXrOinXb7YjBekY4hw");
        HttpRequest request = HttpRequest.post("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token="+token)
                .body(json.toString());

        return request.execute();
    }
}
