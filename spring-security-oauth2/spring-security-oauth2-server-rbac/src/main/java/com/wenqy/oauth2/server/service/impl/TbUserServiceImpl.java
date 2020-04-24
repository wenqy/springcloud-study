package com.wenqy.oauth2.server.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wenqy.oauth2.server.entity.TbUser;
import com.wenqy.oauth2.server.mapper.TbUserMapper;
import com.wenqy.oauth2.server.service.TbUserService;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUsername(String username) {
        return tbUserMapper.findByUserName(username);
    }
}