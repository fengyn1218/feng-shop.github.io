package cn.feng.my.shop.commons.dto;

import cn.feng.my.shop.commons.persistence.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 分页数据传输对象
 * @author:冯雨南
 * @createDate: 2020/4/11
 * @version:1.0.0
 */
public class PageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
