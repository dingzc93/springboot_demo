package com.example.demo.domain.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户登录信息表
 * </p>
 *
 * @author mybatis plus
 * @since 2021-04-12
 */
@TableName("user_login_info")
public class UserLoginInfoDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登录名
     */
    private String name;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 登录token
     */
    private String token;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserLoginInfoDO{" +
        "id=" + id +
        ", name=" + name +
        ", password=" + password +
        ", lastLoginTime=" + lastLoginTime +
        ", token=" + token +
        "}";
    }
}
