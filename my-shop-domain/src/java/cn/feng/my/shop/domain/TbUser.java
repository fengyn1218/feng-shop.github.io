package cn.feng.my.shop.domain;

import cn.feng.my.shop.commons.persistence.BaseEntity;
import cn.feng.my.shop.commons.utils.RegexpUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;


/**
 * @description: 与数据库用户信息表格对应的实体类
 * @author: 冯雨南
 * @createDate: 2020/3/17
 * @version: 1.0.0
 */
public class TbUser extends BaseEntity {

    @Length(min = 6, max = 20, message = "用户名长度必须介于 6 和 20 之间")
    private String username;

    @Length(min = 6, max = 20, message = "密码长度必须介于 6 和 20 之间")
    private String password;

    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确，请重新输入")
    private String phone;

    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确，请重新输入")
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //此注解作用：在json交互中忽略密码属性
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmil() {
        return email;
    }

    public void setEmil(String emil) {
        this.email = emil;
    }


}
