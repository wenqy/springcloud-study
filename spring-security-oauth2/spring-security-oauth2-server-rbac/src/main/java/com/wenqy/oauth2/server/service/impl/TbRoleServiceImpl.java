package com.wenqy.oauth2.server.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wenqy.oauth2.server.mapper.TbRoleMapper;
import com.wenqy.oauth2.server.service.TbRoleService;

@Service
public class TbRoleServiceImpl implements TbRoleService{

    @Resource
    private TbRoleMapper tbRoleMapper;

}