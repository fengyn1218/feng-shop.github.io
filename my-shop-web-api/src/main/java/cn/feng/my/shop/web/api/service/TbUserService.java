package cn.feng.my.shop.web.api.service;

import cn.feng.my.shop.commons.dto.BaseResult;
import cn.feng.my.shop.domain.TbUser;

public interface TbUserService {
    TbUser login(TbUser tbUser);

    BaseResult insert(TbUser tbUser);

    int iCheckRepeat(TbUser tbUser);
}
