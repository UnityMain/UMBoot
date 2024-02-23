package com.unitymain.core.utils;

import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.SneakyThrows;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.util.HashMap;
import java.util.Map;

public class Demo4 {
    @SneakyThrows
    public static void main(String[] args) {
        String a = new String();
        a.toString();
        String url = "https://www.bilibili.com/video/BV1uX4y1c7Ro?spm_id_from=333.851.b_62696c695f7265706f72745f64616e6365.6";
        String html = HttpRequest.get(url)
                .execute().body();
        JXDocument jxDocument = JXDocument.create(html);
        JXNode script = jxDocument.selNOne("//script[contains(text(),'__playinfo__')]");
        String value = script.value().toString();
        String replace = StrUtil.replace(value, "<script>window.__playinfo__=", "");
        replace = StrUtil.replace(replace, "</script>", "");
        JSONObject jsonObject = JSONUtil.parseObj(replace);
        JSONObject dash = jsonObject.getJSONObject("data")
                .getJSONObject("dash");
        JSONArray video = dash.getJSONArray("video");
        JSONArray audio = dash.getJSONArray("audio");

        String videoUrl = video.getJSONObject(0)
                .getStr("baseUrl");

        String audioUrl = audio.getJSONObject(0)
                .getStr("baseUrl");


        HttpRequest.get(videoUrl)
                .header(Header.REFERER, url)
                .execute().writeBody("/Users/panyuanbiao/Documents/" +
                        "work/UmBoot/out/temp.mp4");

        HttpRequest.get(audioUrl)
                .header(Header.REFERER, url)
                .execute().writeBody("/Users/panyuanbiao/Documents/" +
                        "work/UmBoot/out/temp.mp3");
        String template = "{ffmpegUrl} -i {inputVideo} -i {inputAudio} -c:v copy -c:a aac -strict experimental {outFileUrl}";
        Map<String, String> paramMap = new HashMap<String, String>() {{
            put("inputVideo", "/Users/panyuanbiao/Documents/work/UmBoot/out/temp.mp4");
            put("inputAudio", "/Users/panyuanbiao/Documents/work/UmBoot/out/temp.mp3");
            put("outFileUrl", "/Users/panyuanbiao/Documents/work/UmBoot/out/123.mp4");
            put("ffmpegUrl", "/Users/panyuanbiao/Documents/work/UmBoot/src/main/resources/lib/ffmpeg");
        }};
        String format = StrUtil.format(template, paramMap);
        String s = RuntimeUtil.execForStr(format);
        System.out.println(s);
    }
}
