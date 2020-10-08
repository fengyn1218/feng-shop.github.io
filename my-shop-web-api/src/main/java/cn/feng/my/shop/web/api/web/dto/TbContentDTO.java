package cn.feng.my.shop.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 内容数据传输对象
 * @author:冯雨南
 * @createDate: 2020/5/13
 * @version:1.0.0
 */
@Data
public class TbContentDTO implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;

}
