package com.unitymain.student.service;

import com.unitymain.student.bean.ErrorBookDto;
import com.unitymain.student.entity.ErrorBook;
import java.util.List;

/**
 * (ErrorBook)表服务接口
 *
 * @author makejava
 * @since 2020-07-22 18:48:52
 */
public interface ErrorBookService {

    /**
     * 查询DTO
     * @return
     */
    List<ErrorBookDto> queryDtoByLimit(String key,String type);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ErrorBook queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ErrorBook> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param errorBook 实例对象
     * @return 实例对象
     */
    ErrorBook insert(ErrorBook errorBook);

    /**
     * 修改数据
     *
     * @param errorBook 实例对象
     * @return 实例对象
     */
    ErrorBook update(ErrorBook errorBook);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}