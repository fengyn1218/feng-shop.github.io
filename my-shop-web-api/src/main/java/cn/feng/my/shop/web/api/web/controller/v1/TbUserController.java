package cn.feng.my.shop.web.api.web.controller.v1;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.domain.TbUser;
import cn.feng.my.shop.web.api.service.TbUserService;
import cn.feng.my.shop.web.api.web.dto.TbUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 会员管理
 * @author:冯雨南
 * @createDate: 2020/5/23
 * @version:1.0.0
 */
@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseResult login(TbUser tbUser) {
        TbUser user = tbUserService.login(tbUser);
        if (user == null) {
            return BaseResult.fail("输入的信息有误，请重新输入");
        } else {
            TbUserDTO tbUserDTO = new TbUserDTO();
            BeanUtils.copyProperties(user, tbUserDTO);
            return BaseResult.sussess("登录成功！！！", tbUserDTO);
        }
    }

    /**
     * @description: 注册信息
     * @param: tbUser
     * @return: cn.feng.my.shop.commons.dto.BaseResult
     * @author:冯雨南
     * @date: 2020/6/2 16:05
     * @version:1.0.0
     **/
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public BaseResult insert(TbUser tbUser) {


        BaseResult baseResult = tbUserService.insert(tbUser);
        TbUserDTO tbUserDTO = new TbUserDTO();
        BeanUtils.copyProperties(tbUser,tbUserDTO);
        baseResult.setData(tbUserDTO);
        return baseResult;
    }

}
