package com.hpe.springboot_crud.service.impl;

import com.hpe.springboot_crud.dao.SysUserMapper;
import com.hpe.springboot_crud.model.SysUser;
import com.hpe.springboot_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper userMapper;

    @Override
    public List<SysUser> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public SysUser selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addUser(SysUser user) {
        return userMapper.addUser(user);
    }

    @Override
    public boolean selectByName(SysUser user, Map<String,Object> map) {
        SysUser sysUser = userMapper.selectByName(user.getName());
        if(sysUser == null){
            map.put("result",0);
            map.put("message","用户不存在");
            return false;
        }
        if(!sysUser.getPassword().equals(user.getPassword())){
            map.put("result",0);
            map.put("message","账户或密码不正确");
            return false;
        }
        map.put("result",1);
        map.put("message","登陆成功");
        return true;
    }

    @Override
    public int update(SysUser user) {
        return userMapper.updateById(user);
    }
}
