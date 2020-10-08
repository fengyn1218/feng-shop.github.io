package cn.feng.my.shop.commons.persistence;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * @description: 所有业务逻辑基类
 * @param: null
 * @return:
 * @author:冯雨南
 * @date: 2020/5/1 16:26
 * @version:1.0.0
 **/
public interface BaseService<T extends BaseEntity> {
    List<T> selectAll();

    BaseResult save(T entity);

    T getById(Long id);

    void deleteMulti(String[] ids);

    void delete(Long id);

    PageInfo<T> page(int start, int length, int draw, T entity);

    int count(T entity);

    void update(T entity);
}
