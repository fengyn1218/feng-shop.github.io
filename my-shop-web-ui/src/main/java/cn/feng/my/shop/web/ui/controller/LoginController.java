package cn.feng.my.shop.web.ui.controller;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.web.ui.api.UsersApi;
import cn.feng.my.shop.web.ui.dto.TbUser;
import com.google.code.kaptcha.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/20
 * @version:1.0.0
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(TbUser tbUser, Model model, HttpServletRequest request) throws Exception {

        //对验证码验证失败
        if (!iCheckVerification(tbUser, request)) {
            model.addAttribute("baseResult", BaseResult.fail("验证码输入不正确"));
            return "login";
        }

        TbUser user = UsersApi.login(tbUser);
        //登录失败
        if (user == null) {
            model.addAttribute("baseResult", BaseResult.fail("用户名或密码错误，请重新输入"));
            return "login";
        }
        //登录成功
        else {
            //将会员信息放入会话
            request.getSession().setAttribute("tbUser", user);
            return "redirect:/index";
        }
    }

    /**
     * @description: 注销登录
     * @param:
     * @return: java.lang.String
     * @author:冯雨南
     * @date: 2020/5/24 17:28
     * @version:1.0.0
     **/
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();

        return "redirect:/index";
    }

    /**
     * @description: 检查验证码
     * @param: tbUser
     * @param: request
     * @return: boolean
     * @author:冯雨南
     * @date: 2020/6/2 14:44
     * @version:1.0.0
     **/
    private boolean iCheckVerification(TbUser tbUser, HttpServletRequest request) {
        String verification = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (tbUser.getVerification().equals(verification)) {
            return true;
        } else {
            return false;
        }
    }
}
