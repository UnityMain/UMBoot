package com.unitymain.student.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.unitymain.student.entity.Anime;
import com.unitymain.student.entity.Subgroup;
import com.unitymain.student.entity.Type;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nzkPlayer")
public class DmhyController {

    @RequestMapping(value = "/subgroup", produces = "application/json;charset=utf-8")
    public JSONObject demo10(HttpServletResponse response) throws IOException {
        
        String body = HttpRequest
                .get("http://www.dmhy.org/topics/advanced-search")
                //.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 10809)))
                .execute().body();
        Document doc = Jsoup.parse(body);
        Elements select = doc.select("#AdvSearchTeam option");

        List<Subgroup> subgroupList = new ArrayList<>();
        for (Element sel : select) {
            Subgroup subgroup = new Subgroup();
            subgroup.setId(Integer.valueOf(sel.attr("value")));
            subgroup.setName(sel.text());
            subgroupList.add(subgroup);
        }

        JSONObject jb = JSONUtil.createObj().putOnce("Subgroups", subgroupList);
        System.out.println(new String(jb.toString().getBytes(StandardCharsets.UTF_8)));

        return jb;
    }

    @RequestMapping(value = "/type", produces = "application/json;charset=utf-8")
    public JSONObject demo11() throws UnsupportedEncodingException {
        String body = HttpRequest
                .get("http://www.dmhy.org/topics/advanced-search")
                //.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 10809)))
                .execute().body();
        Document doc = Jsoup.parse(body);
        Elements select = doc.select("#AdvSearchSort option");

        List<Type> typeList = new ArrayList<>();
        for (Element sel : select) {
            Type type = new Type();

            type.setId(Integer.valueOf(sel.attr("value")));
            type.setName(sel.text());
            typeList.add(type);
        }

        JSONObject jb = JSONUtil.createObj().putOnce("types", typeList);
        System.out.println(new String(jb.toString().getBytes(StandardCharsets.UTF_8)));



        return jb;
    }

    @RequestMapping(value = "/list", produces = "application/json;charset=utf-8")
    public JSONObject demo12(String type, String subgroup, String keyword) {
        Map<String, Object> form = new HashMap<>();
        if (StrUtil.isNotEmpty(type)) {
            form.put("sort_id", type);
        }
        if (StrUtil.isNotEmpty(subgroup)) {
            form.put("team_id", subgroup);
        }
        if (StrUtil.isNotEmpty(keyword)) {
            form.put("keyword", keyword);
        }
        String body = HttpRequest
                .get("http://www.dmhy.org/topics/list")
                //.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 10809)))
                .form(form)
                .execute().body();
        Document doc = Jsoup.parse(body);
        Elements element = doc.select("#topic_list > tbody > tr");
        List<Anime> animes = new ArrayList<>();
        for (Element tr : element) {
            Anime anime = new Anime();
            String PublishDate = tr.children().get(0).child(0).text();
            String TypeId = StrUtil.subAfter(tr.children().get(1).child(0).attr("href"),
                    "sort_id/", false);
            String TypeName = tr.children().get(1).select("font").text();
            String SubgroupName = null;
            String Title = null;
            String PageUrl = null;
            String SubgroupId = null;
            if (tr.children().get(2).child(0).is("span")) {
                SubgroupName = tr.children().get(2).select("a").get(0).text();
                SubgroupId = StrUtil.subAfter(tr.children().get(2).select("a").get(0).attr("href")
                        , "team_id/", false);
                Title = tr.children().get(2).select("a").get(1).text();
                PageUrl = "http://www.dmhy.org" +
                        tr.children().get(2).select("a").get(1).attr("href");
            } else {
                Title = tr.children().get(2).select("a").get(0).text();
                PageUrl = "http://www.dmhy.org" +
                        tr.children().get(2).select("a").get(0).attr("href");
            }
            String Magnet = tr.children().get(3).select("a").get(0).attr("href");
            String FileSize = tr.children().get(4).text();

            anime.setPublishDate(PublishDate);
            anime.setFileSize(FileSize);
            anime.setTypeName(TypeName);
            anime.setTitle(Title);
            anime.setSubgroupName(SubgroupName);
            anime.setMagnet(Magnet);
            anime.setPageUrl(PageUrl);
            anime.setTypeId(Integer.valueOf(TypeId));
            if (StrUtil.isNotEmpty(SubgroupId)) {
                anime.setSubgroupId(Integer.valueOf(SubgroupId));
            }

            animes.add(anime);
        }
        JSONObject jb = new JSONObject();
        jb.set("HasMore", true);
        jb.set("Resources", animes);
        System.out.println(jb);
        return jb;
    }


}


