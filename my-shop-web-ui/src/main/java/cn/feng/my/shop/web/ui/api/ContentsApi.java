package cn.feng.my.shop.web.ui.api;

import cn.feng.my.shop.commons.utils.HttpClientUtils;
import cn.feng.my.shop.commons.utils.MapperUtils;
import cn.feng.my.shop.web.ui.dto.TbContent;

import java.util.List;

/**
 * @description: 内容管理接口
 * @author:冯雨南
 * @createDate: 2020/5/17
 * @version:1.0.0
 */
public class ContentsApi {

    public static List<TbContent> findContentsByCategoryId() {

        String result = HttpClientUtils.doGet(API.API_CONTENTS+"89");
        List<TbContent> tbContents = null;

        try {
            tbContents = MapperUtils.json2listByTree(result, "data", TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tbContents;
    }
}
