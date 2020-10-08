package cn.feng.my.shop.web.admin.web.controller;

import cn.feng.my.shop.commons.utils.CookieUtils;
import cn.feng.my.shop.domain.TbUser;
import cn.feng.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: 冯雨南
 * @createDate: 2020/3/15
 * @version: 1.0.0
 */
@Controller
public class LoginController {

    @Autowired
    private TbUserService tbUserService;

    Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(HttpServletRequest req) {
        logger.info("我叫冯雨南");
        String userInfo = CookieUtils.getCookieValue(req, "userInfo");
        if (!StringUtils.isBlank(userInfo)) {
            String[] arr = userInfo.split(":");
            req.setAttribute("emil", arr[0]);
            req.setAttribute("password", arr[1]);
            req.setAttribute("isCheck", "checked");
        }
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String emil, @RequestParam(required = true) String password, HttpServletRequest request, HttpServletResponse response, Model model) {
        boolean isRemember = request.getParameter("isRemember") == null ? false : true;

        if (!isRemember) {
            CookieUtils.deleteCookie(request, response, "userInfo");
        }

        TbUser tbUser = tbUserService.login(emil, password);
        //登录失败
        if (null == tbUser) {
            model.addAttribute("message", "用户名或密码错误，请重新输入");
            return "login";
        }
        //登陆成功
        else {
            if (isRemember) {
                //用户信息存储一周
                CookieUtils.setCookie(request, response, "userInfo", String.format("%s:%s", emil
                        , password), 7 * 24 * 60 * 60);
            }
            //将登陆信息放入会话
            request.getSession().setAttribute("user", tbUser);
            //重定向，默认是转发
            return "redirect:/main";

        }

    }

    /**
     * @description: 注销登陆账号
     * @param: httpServletRequest
     * @return: java.lang.String
     * @author:冯雨南
     * @date: 2020/4/14 13:33
     * @version:1.0.0
     **/
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return "redirect:/login";
    }
}

