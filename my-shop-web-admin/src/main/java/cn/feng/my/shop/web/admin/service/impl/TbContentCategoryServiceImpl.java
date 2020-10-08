package cn.feng.my.shop.web.admin.service.impl;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.commons.validator.BeanValidator;
import cn.feng.my.shop.domain.TbContentCategory;
import cn.feng.my.shop.web.admin.abstracts.AbstractBaseTreeServiceImpl;
import cn.feng.my.shop.web.admin.dao.TbContentCategoryDao;
import cn.feng.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/4/14
 * @version:1.0.0
 */

@Service
@Transactional(readOnly = true)
public class TbContentCategoryServiceImpl extends AbstractBaseTreeServiceImpl<TbContentCategory, TbContentCategoryDao> implements TbContentCategoryService {


    @Override
    @Transactional(readOnly = false)
    public BaseResult save(TbContentCategory tbContentCategory) {
        String validator = BeanValidator.validator(tbContentCategory);

        //验证未通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            TbContentCategory parent = tbContentCategory.getParent();
            tbContentCategory.setUpdate(new Date());

            //如果没有选择父节点，为根目录
            if (parent == null || parent.getId() == null) {
                //0代表根目录
                parent.setId(0L);
            }
            //新增
            if (tbContentCategory.getId() == null) {
                tbContentCategory.setCreated(new Date());
                tbContentCategory.setIsParent(false);

                //判断当前新增节点有没有父级节点
                if (parent.getId() != 0L) {
                    TbContentCategory newParent = getById(parent.getId());
                    if (newParent != null) {
                        //为父级节点设置isParent为true
                        newParent.setIsParent(true);
                        update(newParent);
                    }
                }
                //父级节点为0,表示为根目录
                else {
                    //根目录一定是父级目录
                    tbContentCategory.setIsParent(true);
                }
                dao.insert(tbContentCategory);
            }
            //修改
            else {
                update(tbContentCategory);
            }
            return BaseResult.sussess("保存成功");
        }

    }
}
