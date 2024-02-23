package com.unitymain.core.service;

import com.unitymain.core.entity.QuestionType;
import java.util.List;

/**
 * (QuestionType)表服务接口
 *
 * @author makejava
 * @since 2020-07-22 23:27:30
 */
public interface QuestionTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    QuestionType queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<QuestionType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param questionType 实例对象
     * @return 实例对象
     */
    QuestionType insert(QuestionType questionType);

    /**
     * 修改数据
     *
     * @param questionType 实例对象
     * @return 实例对象
     */
    QuestionType update(QuestionType questionType);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}