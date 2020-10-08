package cn.feng.my.shop.web.api.service;

import cn.feng.my.shop.domain.TbContent;
import cn.feng.my.shop.web.api.dao.TbContentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/12
 * @version:1.0.0
 */

public interface TbContentService {

    //根据类别ID查询内容列表
    List<TbContent> selectByCategoryId(Long categoryId);
}
