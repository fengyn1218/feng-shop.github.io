package cn.feng.my.shop.web.ui.api;

import cn.feng.my.shop.commons.utils.HttpClientUtils;
import cn.feng.my.shop.commons.utils.MapperUtils;
import cn.feng.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 会员管理接口
 * @author:冯雨南
 * @createDate: 2020/5/23
 * @version:1.0.0
 */
public class UsersApi {

    public static TbUser login(TbUser tbUser) throws Exception {

        List<BasicNameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("username", tbUser.getUsername()));
        list.add(new BasicNameValuePair("password", tbUser.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, list.toArray(new BasicNameValuePair[list.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json, "data", TbUser.class);
        return user;
    }

    public static String insert(TbUser tbUser) throws Exception {

        List<BasicNameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("username", tbUser.getUsername()));
        list.add(new BasicNameValuePair("password", tbUser.getPassword()));
        list.add(new BasicNameValuePair("email", tbUser.getEmail()));
        list.add(new BasicNameValuePair("phone", tbUser.getPhone()));

        String json = HttpClientUtils.doPost(API.API_USERS_REGISTER, list.toArray(new BasicNameValuePair[list.size()]));
        System.out.println(json);
        String code = MapperUtils.json2pojoByTree(json, "status", String.class);
        return code;
    }

}
