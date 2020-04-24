package com.wenqy.oauth2.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wenqy.oauth2.server.entity.TbPermission;

public interface TbPermissionMapper {
	
	@Select("SELECT" + 
			"      p.*" + 
			"    FROM" + 
			"      tb_user AS u" + 
			"      LEFT JOIN tb_user_role AS ur" + 
			"        ON u.id = ur.user_id" + 
			"      LEFT JOIN tb_role AS r" + 
			"        ON r.id = ur.role_id" + 
			"      LEFT JOIN tb_role_permission AS rp" + 
			"        ON r.id = rp.role_id" + 
			"      LEFT JOIN tb_permission AS p" + 
			"        ON p.id = rp.permission_id" + 
			"    WHERE u.id = ${userId}")
    List<TbPermission> selectByUserId(@Param("userId") Long userId);
}