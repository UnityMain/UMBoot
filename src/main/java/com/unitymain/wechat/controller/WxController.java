package com.unitymain.wechat.controller;

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import com.unitymain.core.bean.Result;
import com.unitymain.wechat.entity.response.AccessToken;
import com.unitymain.wechat.service.AccessTokenService;
import com.unitymain.wechat.service.MaterialService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * @author unitymain
 */
@RestController
@RequestMapping("/wx")
public class WxController {
    @Resource
    private AccessTokenService accessTokenService;
    @Resource
    private MaterialService materialService;

    @GetMapping("/getToken")
    public Result<AccessToken> getToken(){

        AccessToken token = accessTokenService.getToken();
        return Result.ok().body(token);
    }

    @RequestMapping("/demo")
    public Result<JSONObject> demo(String partId){
        JSONObject json = new JSONObject();
        System.out.println(partId);
        return Result.ok().body(null);
    }

    @GetMapping("/getMaterialCount")
    public Result<JSONObject> getMaterialCount(){
        JSONObject materialCount = materialService.getMaterialCount();
        return Result.ok().body(materialCount);
    }

    @GetMapping("/batchgetMaterial")
    public Result<JSONObject> batchgetMaterial(){
        List<JSONObject> a = new ArrayList<>();

//        JSONObject batchgetMaterial = materialService.batchgetMaterial();
        return Result.ok().body(null);
    }

    @GetMapping("/getMaterial")
    public void getMaterial(HttpServletResponse response){
        HttpResponse body = materialService.getMaterial();
        String content_desc = body.header(Header.CONTENT_DISPOSITION);

        response.addHeader(Header.CONTENT_DISPOSITION.getValue(),content_desc);
        ServletUtil.write(response,body.bodyStream());
    }
}
