package com.example.demo.login.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户登录信息表
 * </p>
 *
 * @author dingzc
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserLoginInfo implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private LocalDateTime lastLoginTime;

    /**
     * 登录token
     */
    private String token;


}
