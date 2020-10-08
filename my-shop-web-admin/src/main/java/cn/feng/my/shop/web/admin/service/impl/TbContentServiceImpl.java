package cn.feng.my.shop.web.admin.service.impl;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.commons.validator.BeanValidator;
import cn.feng.my.shop.domain.TbContent;
import cn.feng.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import cn.feng.my.shop.web.admin.dao.TbContentDao;
import cn.feng.my.shop.web.admin.service.TbContentService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/4/16
 * @version:1.0.0
 */
@Service
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent, TbContentDao> implements TbContentService {

    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            tbContent.setUpdate(new Date());
            //新增
            if (tbContent.getId() == null) {
                tbContent.setCreated(new Date());
                dao.insert(tbContent);
            }
            //编辑用户
            else {
                update(tbContent);
            }
            return BaseResult.sussess("保存内容信息成功");
        }

    }

    /**
     * @description: 用户信息的有效性验证
     * @param: tbUser
     * @return: void
     * @author: 冯雨南
     * @date: 2020/3/20 16:02
     * @version: 1.0.0
     **/
    // private BaseResult checkTbContent(TbContent tbContent) {
    //     BaseResult baseResult = BaseResult.sussess();
    //     //非空验证
    //     if (tbContent.getCategoryId() == null) {
    //         baseResult = BaseResult.fail("内容所属分类不能为空");
    //     } else if (StringUtils.isBlank(tbContent.getTitle())) {
    //         baseResult = BaseResult.fail("内容标题不能为空");
    //     } else if (StringUtils.isBlank(tbContent.getSubTitle())) {
    //         baseResult = BaseResult.fail("子标题不能为空");
    //     } else if (StringUtils.isBlank(tbContent.getTitleDesc())) {
    //         baseResult = BaseResult.fail("标题描述不能为空");
    //     } else if (StringUtils.isBlank(tbContent.getUrl())) {
    //         baseResult = BaseResult.fail("链接地址不能为空");
    //     }
    //
    //
    //     return baseResult;
    // }
}
