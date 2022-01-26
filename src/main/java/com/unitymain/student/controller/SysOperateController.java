package com.unitymain.student.controller;

import com.unitymain.student.entity.SysOperate;
import com.unitymain.student.service.SysOperateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 后台接口操作权限(SysOperate)表控制层
 *
 * @author UnityMain
 * @since 2022-01-20 17:36:00
 */
@RestController
@RequestMapping("sysOperate")
public class SysOperateController {
    /**
     * 服务对象
     */
    @Resource
    private SysOperateService sysOperateService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysOperate selectOne(Integer id) {
        return this.sysOperateService.queryById(id);
    }

}