package cn.feng.my.shop.web.admin.web.controller;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.domain.TbContentCategory;
import cn.feng.my.shop.web.admin.abstracts.AbstractBaseTreeController;
import cn.feng.my.shop.web.admin.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 内容分类管理
 * @author:冯雨南
 * @createDate: 2020/4/14
 * @version:1.0.0
 */
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController extends AbstractBaseTreeController<TbContentCategory, TbContentCategoryService> {
    
    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id) {
        TbContentCategory tbContentCategory;
        if (null != id) {
            tbContentCategory = service.getById(id);
        } else {
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;
    }

    @Override
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = service.selectAll();

        //排序
        sortList(sourceList, targetList, 0L);

        model.addAttribute("tbContentCategories", targetList);
        return "content_category_list";
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "tree/data", method = RequestMethod.POST)
    public List<TbContentCategory> treeData(Long id) {
        if (null == id) {
            id = 0L;
        }
        return service.selectByPid(id);
    }


    @Override
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(TbContentCategory tbContentCategory) {
        return "content_category_form";
    }

    /**
     * @description: 保存数据，用于新增和编辑
     * @param: tbUser
     * @param: model
     * @param: redirectAttributes
     * @return: java.lang.String
     * @author:冯雨南
     * @date: 2020/4/13 17:33
     * @version:1.0.0
     **/
    @Override
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContentCategory tbContentCategory, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = service.save(tbContentCategory);
        //保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/category/list";
        }
        //保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "content_category_form";
        }

    }

    @RequestMapping(value = "deleteOne", method = RequestMethod.GET)
    public String delete(Long id) {

        service.delete(id);
        return "redirect:/content/category/list";
    }

}
