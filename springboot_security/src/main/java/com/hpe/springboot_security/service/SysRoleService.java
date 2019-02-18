package com.hpe.springboot_security.service;

import com.hpe.springboot_security.dao.mapper.SysRoleMapper;
import com.hpe.springboot_security.dao.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {
   @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectByPrimaryKey(id);
    }
}
