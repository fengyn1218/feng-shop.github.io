package cn.feng.my.shop.web.admin.web.controller;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.commons.dto.PageInfo;
import cn.feng.my.shop.domain.TbContent;
import cn.feng.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/4/16
 * @version:1.0.0
 */

@Controller
@RequestMapping(value = "/content")
public class ContentController {
    @Autowired
    private TbContentService tbContentService;

    /**
     * @description: 每次都会执行，根据id获取信息
     * @param: id
     * @return: cn.feng.my.shop.domain.TbUser
     * @author:冯雨南
     * @date: 2020/4/13 17:34
     * @version:1.0.0
     **/
    @ModelAttribute
    public TbContent getTbUser(Long id) {
        TbContent tbContent = null;
        if (null != id) {
            tbContent = tbContentService.getById(id);
        } else {
            tbContent = new TbContent();
        }
        return tbContent;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "content_list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "content_form";
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
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbContentService.save(tbContent);
        //保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/list";
        }
        //保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "content_form";
        }

    }


    /**
     * @description: 批量删除
     * @param: ids 需要删除的id数组
     * @return: cn.feng.my.shop.commons.dto.BaseResult
     * @author:冯雨南
     * @date: 2020/4/13 17:32
     * @version:1.0.0
     **/
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNoneBlank(ids)) {
            String[] idArray = ids.split(",");
            tbContentService.deleteMulti(idArray);
            baseResult = BaseResult.sussess("删除数据成功");
        } else {
            baseResult = BaseResult.fail("删除数据失败");
        }
        return baseResult;

    }


    @RequestMapping(value = "deleteOne", method = RequestMethod.GET)
    public String deleteOne(Long id) {
        tbContentService.delete(id);
        return "content_list";
    }


    /**
     * @description: 分页查询
     * @param: request
     * @return: java.lang.String
     * @author:冯雨南
     * @date: 2020/4/914:26
     * @version:1.0.0
     **/
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent) {

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        //封装DataTable需要的结果
        PageInfo<TbContent> pageInfo = tbContentService.page(start, length, draw, tbContent);
        return pageInfo;
    }


    /**
     * @description: 显示内容详情
     * @param: tbUser
     * @return: java.lang.String
     * @author:冯雨南
     * @date: 2020/4/12 15:11
     * @version:1.0.0
     **/
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(TbContent tbContent) {
        return "content_detail";
    }


}
