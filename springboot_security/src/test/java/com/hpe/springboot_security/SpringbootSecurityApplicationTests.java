package com.hpe.springboot_security;

import com.hpe.springboot_security.dao.mapper.SysRoleMapper;
import com.hpe.springboot_security.dao.mapper.SysUserMapper;
import com.hpe.springboot_security.dao.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.hpe.springboot_security.dao.mapper")
public class SpringbootSecurityApplicationTests {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Test
    public void contextLoads() {
        SysUser user = userMapper.selectByName("hailan");
        System.out.println(user);
    }

}

