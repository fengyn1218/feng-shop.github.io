package cn.feng.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * @description: 所有数据访问层的基类
 * @param: null
 * @return:
 * @author:冯雨南
 * @date: 2020/5/1 15:53
 * @version:1.0.0
 **/
public interface BaseDao<T extends BaseEntity> {
    /**
     * @description: 查询所有数据
     * @param:
     * @return: java.util.List<cn.feng.my.shop.domain.entity>
     * @author: 冯雨南
     * @date: 2020/3/17 16:48
     * @version: 1.0.0
     **/
    List<T> selectAll();


    /**
     * @description: 新增
     * @param: entity
     * @return: void
     * @author:冯雨南
     * @date: 2020/3/2316:34
     * @version:1.0.0
     **/
    void insert(T entity);

    /**
     * @description: 更新信息
     * @param: entity
     * @return: void
     * @author:冯雨南
     * @date: 20/3/2316:34
     * @version:1.0.0
     **/
    void update(T entity);

    /**
     * @description: 根据ID查询
     * @param: id
     * @return: cn.feng.my.shop.domain.entity
     * @author:冯雨南
     * @date: 2020/3/2316:35
     * @version:1.0.0
     **/
    T getById(Long id);


    /**
     * @description: 实现批量删除功能
     * @param: ids
     * @return: void
     * @author:冯雨南
     * @date: 2020/4/516:07
     * @version:1.0.0
     **/
    void deleteMulti(String[] ids);

    /**
     * @description: 实现删除功能
     * @param: id
     * @return: void
     * @author:冯雨南
     * @date: 2020/4/13 16:42
     * @version:1.0.0
     **/
    void delete(Long id);

    /**
     * @description: 分页查找
     * @param: params 需要两个参数，一个start一个length。
     * @return: java.util.List<cn.feng.my.shop.domain.TbUser>
     * @author:冯雨南
     * @date: 2020/4/914:57
     * @version:1.0.0
     **/
    List<T> page(Map<String, Object> params);

    /**
     * @description: 查询总笔数
     * @return: int
     * @author:冯雨南
     * @date: 2020/4/916:07
     * @version:1.0.0
     **/
    int count(T entity);


}
