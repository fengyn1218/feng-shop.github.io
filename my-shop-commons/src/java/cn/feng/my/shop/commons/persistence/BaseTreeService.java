package cn.feng.my.shop.commons.persistence;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * @description: 树形逻辑处理层基类
 * @param: null
 * @return:
 * @author:冯雨南
 * @date: 2020/5/3 14:59
 * @version:1.0.0
 **/
public interface BaseTreeService<T extends BaseEntity> {
    List<T> selectAll();

    BaseResult save(T entity);

    T getById(Long id);

    void update(T entity);

    void delete(Long id);


    List<T> selectByPid(Long pid);


}
