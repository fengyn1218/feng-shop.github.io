package cn.feng.my.shop.web.admin.service;

import cn.feng.my.shop.commons.persistence.BaseService;
import cn.feng.my.shop.domain.TbUser;

public interface TbUserService extends BaseService<TbUser> {

    TbUser login(String email, String password);


}
