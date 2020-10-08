package cn.feng.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/17
 * @version:1.0.0
 */
@Data
public class TbContent implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;

}
