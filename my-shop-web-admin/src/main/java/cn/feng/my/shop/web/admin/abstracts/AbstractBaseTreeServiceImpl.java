package cn.feng.my.shop.web.admin.abstracts;

import cn.feng.my.shop.commons.persistence.BaseEntity;
import cn.feng.my.shop.commons.persistence.BaseTreeDao;
import cn.feng.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description: 通用的树形的逻辑处理层实现类
 * @author:冯雨南
 * @createDate: 2020/5/3
 * @version:1.0.0
 */
public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity, D extends BaseTreeDao<T>> implements BaseTreeService<T> {

    @Autowired
    protected D dao;


    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(T entity) {
        entity.setUpdate(new Date());
        dao.update(entity);
    }

    @Override
    public List<T> selectByPid(Long pid) {
        return dao.selectByPid(pid);
    }


}
