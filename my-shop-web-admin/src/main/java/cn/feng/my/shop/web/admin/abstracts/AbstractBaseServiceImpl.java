package cn.feng.my.shop.web.admin.abstracts;

import cn.feng.my.shop.commons.dto.PageInfo;
import cn.feng.my.shop.commons.persistence.BaseDao;
import cn.feng.my.shop.commons.persistence.BaseEntity;
import cn.feng.my.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/4
 * @version:1.0.0
 */
public abstract class AbstractBaseServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements BaseService<T> {

    @Autowired
    protected D dao;

    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }


    @Override
    public T getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void deleteMulti(String[] ids) {
        dao.deleteMulti(ids);
    }

    @Override
    public int count(T entity) {
        return dao.count(entity);
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }




    @Override
    public PageInfo<T> page(int start, int length, int draw, T entity) {

        int count = count(entity);
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", entity);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(dao.page(params));


        return pageInfo;
    }
}

