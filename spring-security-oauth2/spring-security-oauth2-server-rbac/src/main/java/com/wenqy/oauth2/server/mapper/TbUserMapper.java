package com.wenqy.oauth2.server.mapper;

import org.apache.ibatis.annotations.Select;

import com.wenqy.oauth2.server.entity.TbUser;

public interface TbUserMapper {
	
	 @Select("select id,username,password,phone,email,created,updated from tb_user where username =#{userId} limit 1")
	 TbUser findByUserName(String userId);
}
