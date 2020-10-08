package cn.feng.my.shop.web.api.dao;

import cn.feng.my.shop.commons.persistence.BaseDao;
import cn.feng.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @description: 会员管理
 * @author:冯雨南
 * @date: 2020/5/23 16:20
 * @version:1.0.0
 **/
@Repository
public interface TbUserDao extends BaseDao<TbUser> {

    /**
     * @description: 登录
     * @param: tbUser
     * @return: cn.feng.my.shop.domain.TbUser
     * @author:冯雨南
     * @date: 2020/5/23 16:19
     * @version:1.0.0
     **/
    TbUser login(TbUser tbUser);

    /**
     * @description: 检查注册重复数据
     * @param: tbUser
     * @return: java.lang.Integer
     * @author:冯雨南
     * @date: 2020/6/3 11:03
     * @version:1.0.0
     **/
    int iCheckRepeat(TbUser tbUser);


}
