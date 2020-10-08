package cn.feng.my.shop.commons.persistence;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/5
 * @version:1.0.0
 */
@Data
public class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {
    private T parent;
    private Boolean isParent;


}
