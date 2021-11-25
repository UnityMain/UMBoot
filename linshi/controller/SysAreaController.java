package com.unitymain.student.controller;

import com.unitymain.student.entity.SysArea;
import com.unitymain.student.service.SysAreaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 地区表(SysArea)表控制层
 *
 * @author makejava
 * @since 2020-09-26 18:46:52
 */
@RestController
@RequestMapping("sysArea")
public class SysAreaController {
    /**
     * 服务对象
     */
    @Resource
    private SysAreaService sysAreaService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysArea selectOne(Integer id) {
        return this.sysAreaService.queryById(id);
    }

}