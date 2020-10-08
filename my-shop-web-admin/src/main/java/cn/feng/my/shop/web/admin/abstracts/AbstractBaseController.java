package cn.feng.my.shop.web.admin.abstracts;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.commons.dto.PageInfo;
import cn.feng.my.shop.commons.persistence.BaseEntity;
import cn.feng.my.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/4
 * @version:1.0.0
 */
public abstract class AbstractBaseController<T extends BaseEntity, S extends BaseService<T>> {

    /**
     * 注入业务逻辑层
     **/
    @Autowired
    protected S service;

    //跳转列表页
    public abstract String list();

    //跳转到表单页
    public abstract String form();

    //保存信息
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);

    //删除
    public abstract BaseResult delete(String ids);

    //分页
    public abstract PageInfo<T> page(HttpServletRequest request, T entity);

    //显示详情
    public abstract String detail(T entity);

}
