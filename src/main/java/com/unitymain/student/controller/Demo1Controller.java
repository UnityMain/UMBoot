package com.unitymain.student.controller;

import cn.hutool.core.io.FastByteArrayOutputStream;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.unitymain.student.entity.Student;
import com.unitymain.student.utils.Demo3;
import com.unitymain.student.utils.Demo4;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.Map;

@RestController
public class Demo1Controller {

    @RequestMapping("/lalala")
    public JSONObject demo(HttpServletRequest request) throws IOException {
        StringBuffer sb = new StringBuffer() ;
        InputStream is = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s = "" ;
        while((s=br.readLine())!=null){
            sb.append(s) ;

        }
        String str =sb.toString();
        JSONObject jsonObject = JSONUtil.parseObj(str);
        return jsonObject;
    }

    @RequestMapping("/login")
    public JSONObject demo2(){
        JSONObject jsonObject =new JSONObject();
        jsonObject.accumulate("hhh","333");
        return jsonObject;
    }





}
