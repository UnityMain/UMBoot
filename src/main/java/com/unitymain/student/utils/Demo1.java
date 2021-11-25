package com.unitymain.student.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        HttpResponse execute = HttpRequest.get("http://www.cwl.gov.cn/cwl_admin/kjxx/findDrawNotice?name=ssq&issueCount=30")
                .header(Header.REFERER, "http://www.cwl.gov.cn/kjxx/ssq/kjgg/")
                .execute();
        JSONObject jsonObject = JSONUtil.parseObj(execute.body());
        JSONArray result = jsonObject.getJSONArray("result");
        List<DoubleColorBall> dcbList = new ArrayList<>();
        List<String> redBall = new ArrayList<>();
        List<String> blueBall = new ArrayList<>();
        result.forEach((k) ->{
            String red = ((JSONObject)k).getStr("red");
            StrUtil.splitTrim(red, ",").forEach(r->redBall.add(r));

            String blue = ((JSONObject)k).getStr("blue");
            blueBall.add(blue);
        });
        List<String> diRedBall = redBall
                .stream().distinct()
                .collect(Collectors.toList());

        List<String> diBlueBall = blueBall
                .stream().distinct()
                .collect(Collectors.toList());

        Collections.shuffle(diRedBall);
        Collections.shuffle(diBlueBall);


        for(int j=0;j<5;j++){
            List<String> restartRedBall = new ArrayList<>();
            restartRedBall.addAll(diRedBall);
            Collections.shuffle(restartRedBall);
            DoubleColorBall doubleColorBall = new DoubleColorBall();
            List<String> outRed = new ArrayList<>();
            for(int i=0;i<6;i++){
                int redNum = RandomUtil.randomInt(restartRedBall.size());
                String red = restartRedBall.remove(redNum);
                outRed.add(red);
            }
            String outBlue = "";
            {
                int blueNum = RandomUtil.randomInt(diBlueBall.size());
                outBlue = diBlueBall.remove(blueNum);
            }
            Collections.sort(outRed);
            doubleColorBall.setRedBall(outRed);
            doubleColorBall.setBlueBall(outBlue);

            dcbList.add(doubleColorBall);
        }



//        redBall

//        for(int i)

        /*List<WeightRandom.WeightObj<String>> blueBall = new ArrayList<>();
        List<WeightRandom.WeightObj<String>> redBall = new ArrayList<>();
        result.forEach((k) -> {
            String blue = ((JSONObject) k).getStr("blue");
            WeightRandom.WeightObj<String> blueObj = new WeightRandom.WeightObj<>(blue, 1);
            blueBall.add(blueObj);

            String red = ((JSONObject) k).getStr("red");
            String[] redArr = red.split(",");
            for (int i = 0; i < redArr.length; i++) {
                WeightRandom.WeightObj<String> redObj = new WeightRandom.WeightObj<>(redArr[i], 1);
                redBall.add(redObj);
            }
        });*/


        /*
        for (int i = 0; i < 5; i++) {
            DoubleColorBall dbc = new DoubleColorBall();
            List<String> redBalls = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                WeightRandom<String> integerWeightRandom = RandomUtil.weightRandom(redBall);
                String red = integerWeightRandom.next();
                redBall.removeIf(
                        stringWeightObj -> StrUtil.equals(stringWeightObj.getObj(),red));
                redBalls.add(red);
            }
            WeightRandom<String> integerWeightRandom = RandomUtil.weightRandom(blueBall);
            Collections.sort(redBalls);
            dbc.setBlueBall(integerWeightRandom.next());
            dbc.setRedBall(redBalls);
            dcbList.add(dbc);
        }*/

        for(DoubleColorBall d : dcbList){
            for (int i=0;i<d.getRedBall().size();i++){
                System.out.print(d.getRedBall().get(i));
                if(i<d.getRedBall().size()-1){
                    System.out.print(",");
                }
            }

            System.out.print("|");
            System.out.print(d.getBlueBall());
            System.out.println("");
        }
    }
}
