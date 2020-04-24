package com.wenqy.oauth2.resource.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wenqy.oauth2.resource.entity.TbContent;

public interface TbContentMapper {

	TbContent selectByPrimaryKey(Long id);

	@Select("select * from tb_content")
	List<TbContent> selectAll();

	int insert(TbContent tbContent);

	int updateByPrimaryKey(TbContent tbContent);

	int deleteByPrimaryKey(Long id);
}