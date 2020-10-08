package cn.feng.my.shop.commons.dto;

import java.io.Serializable;

/**
 * @description: 自定义返回结果
 * @author: 冯雨南
 * @createDate: 2020/3/20
 * @version: 1.0.0
 */
public class BaseResult implements Serializable {
    //状态码
    private int status;
    //返回消息
    private String message;
    //传输数据
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static BaseResult sussess() {
        return BaseResult.createdBase(200, "成功", null);
    }

    public static BaseResult sussess(String message) {
        return BaseResult.createdBase(200, message, null);
    }

    public static BaseResult sussess(String message, Object data) {
        return BaseResult.createdBase(200, message, data);
    }

    public static BaseResult fail() {
        return BaseResult.createdBase(500, "失败", null);
    }

    public static BaseResult fail(String message) {
        return BaseResult.createdBase(500, message, null);
    }

    public static BaseResult fail(int status, String message) {
        return BaseResult.createdBase(status, message, null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static BaseResult createdBase(int status, String message, Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setData(data);
        return baseResult;
    }
}
