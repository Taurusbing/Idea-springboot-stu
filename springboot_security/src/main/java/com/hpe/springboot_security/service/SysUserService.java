package com.hpe.springboot_security.service;

import com.hpe.springboot_security.dao.mapper.SysUserMapper;
import com.hpe.springboot_security.dao.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public SysUser selectByName(String name){
        return userMapper.selectByName(name);
    }
 }
