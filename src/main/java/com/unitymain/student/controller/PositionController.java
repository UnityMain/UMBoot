package com.unitymain.student.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.unitymain.student.entity.Position;
import com.unitymain.student.service.PositionService;
import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * (Position)表控制层
 *
 * @author makejava
 * @since 2020-09-25 22:19:20
 */

@CrossOrigin
@RestController
@RequestMapping("position")
public class PositionController {
    /**
     * 服务对象
     */
    @Autowired
    private PositionService positionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Position selectOne(Integer id) {
        return this.positionService.queryById(id);
    }
    @GetMapping("all")
    public List<Position> selectAll(String fromArea,String education,String zy) {
        QueryWrapper<Position> queryWrapper = new QueryWrapper<>();
        if(StrUtil.isNotEmpty(fromArea)){
            queryWrapper.eq("from_area",fromArea);
        }
        if(StrUtil.isNotEmpty(education)){
            queryWrapper.like("education",education);
        }
        if(StrUtil.isNotEmpty(zy)){
            queryWrapper.like("zhongzhuan_zy",zy);
            queryWrapper.or().like("dazhuan_zy",zy);
            queryWrapper.or().like("benke_zy",zy);
            queryWrapper.or().like("yanjiusheng_zy",zy);
        }
        return this.positionService.list(queryWrapper);
    }

}