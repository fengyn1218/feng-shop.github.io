package cn.feng.my.shop.web.admin.dao;

import cn.feng.my.shop.commons.persistence.BaseDao;
import cn.feng.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbUserDao extends BaseDao<TbUser> {

    /**
     * @description: 根据邮箱查询用户信息
     * @param: email
     * @return: cn.feng.my.shop.domain.TbUser
     * @author: 冯雨南
     * @date: 2020/3/18 15:30
     * @version: 1.0.0
     **/
    TbUser getByEmail(String email);

}
