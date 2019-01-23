package com.hpe.service;

import com.hpe.mapper.UserMapper;
import com.hpe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(int id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> selectAll(){
        return userMapper.selectAll();
    }

//    public boolean update(){
//        return userMapper
//    }
}
