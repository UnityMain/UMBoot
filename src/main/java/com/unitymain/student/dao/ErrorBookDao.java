package com.unitymain.student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unitymain.student.bean.ErrorBookDto;
import com.unitymain.student.entity.ErrorBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ErrorBook)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-22 18:48:52
 */
@Mapper
public interface ErrorBookDao extends BaseMapper<ErrorBookDao> {

    /**
     * 查询DTO
     * @return
     */
    List<ErrorBookDto> queryDtoByLimit(@Param("key") String key,@Param("type") String type);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ErrorBook queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ErrorBook> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param errorBook 实例对象
     * @return 对象列表
     */
    List<ErrorBook> queryAll(ErrorBook errorBook);

    /**
     * 新增数据
     *
     * @param errorBook 实例对象
     * @return 影响行数
     */
    int insert(ErrorBook errorBook);

    /**
     * 修改数据
     *
     * @param errorBook 实例对象
     * @return 影响行数
     */
    int update(ErrorBook errorBook);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}