package cn.feng.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/23
 * @version:1.0.0
 */
@Data
public class TbUser implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String verification;

}
