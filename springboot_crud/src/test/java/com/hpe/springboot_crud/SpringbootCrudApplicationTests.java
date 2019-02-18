package com.hpe.springboot_crud;

import com.hpe.springboot_crud.dao.SysUserMapper;
import com.hpe.springboot_crud.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@MapperScan("com.hpe.springboot_crud.dao")
public class SpringbootCrudApplicationTests {

    @Autowired
    private SysUserMapper userMapper;

    @Test
    public void contextLoads() {
        SysUser sysUser = userMapper.selectByPrimaryKey(1);
        System.out.println(sysUser.toString());
    }

    @Test
    public void selectAll(){
        List<SysUser> sysUsers = userMapper.queryAll();
        for(SysUser sysUser : sysUsers){
            System.out.println(sysUser);
        }
    }

    @Test
    public void add(){
        SysUser sysUser = new SysUser();
        sysUser.setName("特仑苏");
        sysUser.setPassword("qwer");
        System.out.println(userMapper.addUser(sysUser));
    }

    @Test
    public void selectByName(){
        System.out.println(userMapper.selectByName("hailan"));
    }
}

