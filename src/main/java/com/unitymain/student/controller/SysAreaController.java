package com.unitymain.student.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.extension.api.R;
import com.unitymain.student.entity.QuestionType;
import com.unitymain.student.entity.SysArea;
import com.unitymain.student.service.SysAreaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 地区表(SysArea)表控制层
 *
 * @author makejava
 * @since 2020-09-26 18:46:52
 */
@RestController
@CrossOrigin
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
    @GetMapping("all")
    public R<List<Tree<String>>> selectAll() {
        List<SysArea> sysAreas = sysAreaService.queryAllByLimit(0, 999);
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();
        for (SysArea sysArea : sysAreas) {
            nodeList.add(new TreeNode(
                    sysArea.getCode(),
                    sysArea.getParentId(),
                    sysArea.getShortName(), 5)
            );
        }
        //配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setNameKey("label");
        treeNodeConfig.setIdKey("value");
        List<Tree<String>> treeList = TreeUtil.build(nodeList, "0",treeNodeConfig,(treeNode, tree) -> {
            tree.setId(treeNode.getId());
            tree.setParentId(treeNode.getParentId());
            tree.setWeight(treeNode.getWeight());
            tree.setName(treeNode.getName());
        });
        return R.ok(treeList);
    }

}