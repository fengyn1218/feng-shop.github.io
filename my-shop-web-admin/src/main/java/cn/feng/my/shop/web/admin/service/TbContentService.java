package cn.feng.my.shop.web.admin.service;

import cn.feng.my.shop.commons.persistence.BaseService;
import cn.feng.my.shop.domain.TbContent;

public interface TbContentService extends BaseService<TbContent> {

    /**
     * @description: 更新信息
     * @param: tbContent
     * @return: void
     * @author:冯雨南
     * @date: 20/3/2316:34
     * @version:1.0.0
     **/
    void update(TbContent tbContent);
}
