package com.unitymain.core;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.unitymain.core.entity.Anime;
import com.unitymain.core.entity.SysOperate;
import org.junit.jupiter.api.Test;

import java.awt.print.PrinterJob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ceshi {

    @Test
    public void test1() throws ParseException {
        String dateStr = "2022-04-02T02:02:53.981 UTC";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date date = dateFormat.parse(dateStr);
        System.out.println(date);
    }

    @Test
    public void test2() {
        SysOperate operate = new SysOperate();
        operate.setCode("测试测试");
        String[] test = {"123", "321"};
        System.out.println(operate);
        System.out.println(test);
        Console.log("测试测试:{}", operate);
        Console.log(test);
        Console.log(operate);
    }

    @Test
    public void test3() {
        System.setProperty("proxyHost", "127.0.0.1");
        System.setProperty("proxyPort", "7890");
        HttpResponse execute = HttpRequest.get("https://www.youtube.com").execute();
        Console.log(execute.body());
    }

    @Test
    public void test4(){
        Student student = new Student();
        student.setName("小明");
        Student student1 = null;
        Student student2 = new Student();
        boolean bool1 = BeanUtil.isNotEmpty(student);
        boolean bool2 = BeanUtil.isNotEmpty(student1);
        boolean bool3 = BeanUtil.isNotEmpty(student2);
        Console.log(bool1);
        Console.log(bool2);
        Console.log(bool3);
    }
}
