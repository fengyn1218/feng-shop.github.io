package cn.feng.my.shop.web.ui.api;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/17
 * @version:1.0.0
 */
public class API {
    //主机地址
    public static final String HOST = "http://localhost:8081/api/v1";

    //内容查询接口
    public static final String API_CONTENTS = HOST + "/contents/";

    //会员管理接口-登录
    public static final String API_USERS_LOGIN=HOST+"/users/login";

    //会员注册接口
    public static final String API_USERS_REGISTER=HOST+"/users/insert";
}
