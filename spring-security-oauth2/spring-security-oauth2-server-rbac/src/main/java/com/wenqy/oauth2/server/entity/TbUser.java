package com.wenqy.oauth2.server.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年3月27日
 */
@Data
public class TbUser implements Serializable {
	
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码，加密存储
     */
    private String password;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 注册邮箱
     */
    private String email;

    private Date created;

    private Date updated;

    private static final long serialVersionUID = 1L;
}