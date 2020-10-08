package cn.feng.my.shop.domain;

import cn.feng.my.shop.commons.persistence.BaseEntity;
import cn.feng.my.shop.commons.persistence.BaseTreeEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @description: 分类管理
 * @author:冯雨南
 * @createDate: 2020/4/14
 * @version:1.0.0
 */
@Data
public class TbContentCategory extends BaseTreeEntity {


    @Length(min = 1, max = 10, message = "姓名长度需要介于1-20之间")
    private String name;
    private Integer status;
    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    private Boolean isParent;
    private TbContentCategory parent;


}
