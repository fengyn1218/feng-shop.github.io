package cn.feng.my.shop.web.api.service.impl;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.commons.validator.BeanValidator;
import cn.feng.my.shop.domain.TbUser;
import cn.feng.my.shop.web.api.dao.TbUserDao;
import cn.feng.my.shop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/23
 * @version:1.0.0
 */
@Service
public class TbuserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public TbUser login(TbUser tbUser) {
        TbUser user = tbUserDao.login(tbUser);

        if (user != null) {
            //将明文密码加密
            String password = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
            if (password.equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }

    @Override
    public BaseResult insert(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        //验证未通过
        if (validator != null) {
            return BaseResult.fail("输入信息有误，请重新输入");
        }
        //验证通过
        else {
            tbUser.setUpdate(new Date());
            tbUser.setCreated(new Date());
            tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
            //判断信息是否重复
            if (tbUserDao.iCheckRepeat(tbUser) > 0) {
                return BaseResult.fail("您的信息已经被注册过了，换个试试");
            }
            tbUserDao.insert(tbUser);
            return BaseResult.sussess("注册成功");
        }
    }

    @Override
    public int iCheckRepeat(TbUser tbUser) {
        return tbUserDao.iCheckRepeat(tbUser);
    }
}
