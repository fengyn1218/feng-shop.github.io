package cn.feng.my.shop.web.api.service.impl;

import cn.feng.my.shop.domain.TbContent;
import cn.feng.my.shop.domain.TbContentCategory;
import cn.feng.my.shop.web.api.dao.TbContentDao;
import cn.feng.my.shop.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/12
 * @version:1.0.0
 */
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectByCategoryId(Long categoryId) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(categoryId);
        TbContent tbContent = new TbContent();
        tbContent.setTbContentCategory(tbContentCategory);
        return tbContentDao.selectByCategoryId(tbContent);
    }
}
