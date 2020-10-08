package cn.feng.my.shop.web.ui.controller;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.web.ui.api.UsersApi;
import cn.feng.my.shop.web.ui.dto.TbUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/20
 * @version:1.0.0
 */
@Controller
public class RegisterController {

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Model model, TbUser tbUser) throws Exception {
        String s = UsersApi.insert(tbUser);
        //注册成功
        if (s.equals("200")) {
            model.addAttribute("baseResult", BaseResult.sussess("注册成功"));
            return "login";
        }
        //注册失败
        else {
            model.addAttribute("baseResult", BaseResult.fail("输入信息有误"));
            return "register";
        }
    }

}
