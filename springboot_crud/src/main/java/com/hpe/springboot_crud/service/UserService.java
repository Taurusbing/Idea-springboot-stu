package com.hpe.springboot_crud.service;

import com.hpe.springboot_crud.model.SysUser;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<SysUser> queryAll();

    SysUser selectById(Integer id);

    int addUser(SysUser user);

    boolean selectByName(SysUser user,Map<String,Object> map);

    int update(SysUser user);
}
