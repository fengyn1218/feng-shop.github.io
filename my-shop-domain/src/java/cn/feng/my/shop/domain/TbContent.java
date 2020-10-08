package cn.feng.my.shop.domain;

import cn.feng.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @description: 内容管理
 * @author:冯雨南
 * @createDate: 2020/4/16
 * @version:1.0.0
 */

@Data
public class TbContent extends BaseEntity {



    @Length(min = 1, max = 20, message = "标题长度需要介于1-20之间")
    private String title;

    @Length(min = 1, max = 20, message = "子标题长度需要介于1-20之间")
    private String subTitle;

    @Length(min = 1, max = 50, message = "标题描述长度需要介于1-50之间")
    private String titleDesc;

    private String url;
    private String pic;
    private String pic2;

    @Length(min = 1, max = 50, message = "内容不能为空")
    private String content;

    @NotNull(message = "父级类目不能为空")
    private TbContentCategory tbContentCategory;

}
