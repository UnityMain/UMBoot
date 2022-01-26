package com.unitymain.student.controller;

import com.unitymain.student.bean.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author unitymain
 */
@RequestMapping("/user")
@RestController
public class SysUserController {

    @RequestMapping("/index")
    public Result index(){
        return Result.ok("我来了");
    }

    @GetMapping("/info")
    public Result info(){
        return Result.failed("个人信息");
    }
}
