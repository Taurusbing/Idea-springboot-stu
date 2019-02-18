package com.hpe.springboot_security.service;

import com.hpe.springboot_security.dao.mapper.SysUserRoleMapper;
import com.hpe.springboot_security.dao.model.SysUserRoleKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRoleKey> listByUserId(Integer userId){
        return userRoleMapper.listByUserId(userId);
    }
}
