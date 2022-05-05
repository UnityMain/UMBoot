package com.unitymain.core.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.unitymain.core.bean.ErrorBookDto;
import com.unitymain.core.entity.QuestionType;
import com.unitymain.core.service.ErrorBookService;
import com.unitymain.core.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
public class ErrorBookController {

    @Autowired
    private ErrorBookService errorBookService;
    @Autowired
    private QuestionTypeService questionTypeService;

    @PostMapping("/errorBookDto")
    public ResponseEntity<List<ErrorBookDto>> queryDtoByLimit(String key,String type) {
        List<ErrorBookDto> errorBookDtos = errorBookService.queryDtoByLimit(key,type);
        return ResponseEntity.ok(errorBookDtos);
    }

    @GetMapping("/questionType")
    public ResponseEntity<List<Tree<Integer>>> queryAllType() {
        List<QuestionType> questionTypes = questionTypeService.queryAllByLimit(0, 999);
        List<TreeNode<Integer>> nodeList = CollUtil.newArrayList();
        for (QuestionType questionType : questionTypes) {
            nodeList.add(new TreeNode(
                    questionType.getId(),
                    questionType.getParentId(),
                    questionType.getLabel(), 5)
            );
        }
        //配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setNameKey("label");
        treeNodeConfig.setIdKey("value");
        List<Tree<Integer>> treeList = TreeUtil.build(nodeList, 0,treeNodeConfig,(treeNode, tree) -> {
            tree.setId(treeNode.getId());
            tree.setParentId(treeNode.getParentId());
            tree.setWeight(treeNode.getWeight());
            tree.setName(treeNode.getName());
        });
        return ResponseEntity.ok(treeList);
    }
}
