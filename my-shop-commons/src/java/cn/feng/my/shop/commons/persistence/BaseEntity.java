package cn.feng.my.shop.commons.persistence;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 实体类基类
 * @author:冯雨南
 * @createDate: 2020/4/11
 * @version:1.0.0
 */
public abstract class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date update;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }


}
