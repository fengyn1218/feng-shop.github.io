package cn.feng.my.shop.web.admin.service.impl;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.commons.utils.RegexpUtils;
import cn.feng.my.shop.commons.validator.BeanValidator;
import cn.feng.my.shop.domain.TbUser;
import cn.feng.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import cn.feng.my.shop.web.admin.dao.TbUserDao;
import cn.feng.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

/**
 * @description:
 * @author: 冯雨南
 * @createDate: 2020/3/17
 * @version: 1.0.0
 */

@Service(value = "tbuserServiceImpl")
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser, TbUserDao> implements TbUserService {


    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = dao.getByEmail(email);
        if (null != tbUser) {
            String s = DigestUtils.md5DigestAsHex(password.getBytes());
            if (s.equals(tbUser.getPassword())) {
                return tbUser;
            }
        }
        return null;
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        //验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        //验证通过
        else {
            tbUser.setUpdate(new Date());
            //新增用户
            if (tbUser.getId() == null) {
                //明文密码加密
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                dao.insert(tbUser);
            }
            //编辑用户
            else {
                update(tbUser);
            }
            return BaseResult.sussess("保存用户信息成功");
        }

    }




    /**
     * @description: 用户信息的有效性验证  (采用Spring Validation，废弃此方法1)
     * @param: tbUser
     * @return: void
     * @author: 冯雨南
     * @date: 2020/3/20 16:02
     * @version: 1.0.0
     **/
    private BaseResult checkTbUser(TbUser tbUser) {
        BaseResult baseResult = BaseResult.sussess();
        //非空验证
        if (StringUtils.isBlank(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号不能为空,请重新输入");
        } else if (!RegexpUtils.checkPhone(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号格式不正确，请重新输入");
        }

        if (StringUtils.isBlank(tbUser.getUsername())) {
            baseResult = BaseResult.fail("用户名不能为空,请重新输入");
        }
        if (StringUtils.isBlank(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空,请重新输入");
        }
        if (StringUtils.isBlank(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不能为空,请重新输入");
        } else if (!RegexpUtils.checkEmail(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入");
        }


        return baseResult;
    }


}
