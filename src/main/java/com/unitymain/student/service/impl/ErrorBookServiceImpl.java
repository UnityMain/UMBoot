package com.unitymain.student.service.impl;

import com.unitymain.student.bean.ErrorBookDto;
import com.unitymain.student.entity.ErrorBook;
import com.unitymain.student.dao.ErrorBookDao;
import com.unitymain.student.service.ErrorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ErrorBook)表服务实现类
 *
 * @author makejava
 * @since 2020-07-22 18:48:52
 */
@Service("errorBookService")
public class ErrorBookServiceImpl implements ErrorBookService {

    @Autowired
    private ErrorBookDao errorBookDao;

    @Override
    public List<ErrorBookDto> queryDtoByLimit(String key,String type) {
        return errorBookDao.queryDtoByLimit(key,type);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ErrorBook queryById(Integer id) {
        return this.errorBookDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ErrorBook> queryAllByLimit(int offset, int limit) {
        return this.errorBookDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param errorBook 实例对象
     * @return 实例对象
     */
    @Override
    public ErrorBook insert(ErrorBook errorBook) {
        this.errorBookDao.insert(errorBook);
        return errorBook;
    }

    /**
     * 修改数据
     *
     * @param errorBook 实例对象
     * @return 实例对象
     */
    @Override
    public ErrorBook update(ErrorBook errorBook) {
        this.errorBookDao.update(errorBook);
        return this.queryById(errorBook.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.errorBookDao.deleteById(id) > 0;
    }
}