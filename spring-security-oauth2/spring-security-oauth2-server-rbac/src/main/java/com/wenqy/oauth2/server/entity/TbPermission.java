package com.wenqy.oauth2.server.entity;
import java.io.Serializable;
import java.util.Date;


import lombok.Data;

/**
 * 权限
 * 
 * @version V5.0
 * @author wenqy
 * @date   2020年3月27日
 */
@Data
public class TbPermission implements Serializable {
    private Long id;

    /**
     * 父权限
     */
    private Long parentId;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限英文名称
     */
    private String enname;

    /**
     * 备注
     */
    private String description;

    private Date created;

    private Date updated;

    private static final long serialVersionUID = 1L;
}