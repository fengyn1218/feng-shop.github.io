package cn.feng.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: 冯雨南
 * @createDate: 2020/3/15
 * @version: 1.0.0
 */
@Controller
public class MainController {
    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }
}
