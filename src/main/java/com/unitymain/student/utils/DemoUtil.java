package com.unitymain.student.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import java.util.List;
import java.util.Map;

public class DemoUtil {

    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader("C:/Users/远彪/Desktop/县市区.xlsx");
        List<Map<String, Object>> maps = reader.readAll();
        for (Map<String,Object> map:maps
             ) {
            if(StrUtil.equals(String.valueOf(map.get("层级关系")),"省份")){
                map.put("父亲ID","-1");
                continue;
            }
            if(StrUtil.equals(String.valueOf(map.get("层级关系")),"城市")){
                String 子节点邮政编码 = String.valueOf(map.get("邮政编号"));
                String sub = StrUtil.sub(子节点邮政编码, 0, 2);
                String 子节点构造邮政编码 =sub + "0000";
                for (Map<String,Object> 比较值:maps){
                    String 父节点邮政编码 = String.valueOf(比较值.get("邮政编号"));
                    if(StrUtil.equals(子节点构造邮政编码,父节点邮政编码)){
                        map.put("父亲ID",父节点邮政编码);
                        break;
                    }
                }
            }
        }
        System.out.println(maps);
    }
}
