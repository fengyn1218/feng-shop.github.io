package cn.feng.my.shop.web.ui.controller;

import cn.feng.my.shop.web.ui.api.ContentsApi;
import cn.feng.my.shop.web.ui.dto.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/14
 * @version:1.0.0
 */
@Controller
public class IndexController {

    /**
     * @description: 跳转首页
     * @return: java.lang.String
     * @author:冯雨南
     * @date: 2020/5/14 16:59
     * @version:1.0.0
     **/
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        requestContentsPPT(model);
        return "index";
    }

    /**
     * @description: 请求幻灯片
     * @param: model
     * @return: void
     * @author:冯雨南
     * @date: 2020/5/17 16:26
     * @version:1.0.0
     **/
    private void requestContentsPPT(Model model) {
        List<TbContent> tbContents = ContentsApi.findContentsByCategoryId();
        model.addAttribute("ppt", tbContents);
    }
}
