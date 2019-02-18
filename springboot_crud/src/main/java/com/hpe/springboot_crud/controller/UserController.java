package com.hpe.springboot_crud.controller;

import com.hpe.springboot_crud.model.SysUser;
import com.hpe.springboot_crud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
//@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String toRegister(){
        return "register";
    }

    /*
    * 查询全部
    * */
    @GetMapping("/home")
    @ResponseBody
    public Object selectAll(){
        Map<String,Object> map = new HashMap<>();
        try{
            List<SysUser> sysUsers = userService.queryAll();
            map.put("result","1");
            map.put("data",sysUsers);
            map.put("message","查询成功");
        }catch (Exception e){
            log.error("selectAll",e);
            map.put("result","0");
            map.put("data",null);
            map.put("message","查询失败");
        }
        return map;
    }

    /*
    * 插入数据
    * */
    @PostMapping("/register")
    @ResponseBody
    public Object addUser(SysUser sysUser){
        Map<String,Object> map = new HashMap<>();
        try{
            userService.addUser(sysUser);
            map.put("result","1");
            map.put("message","注册成功");
        }catch(Exception e){
            log.error("addUser",e);
            map.put("result","0");
            map.put("message","插入异常");
        }
        return map;
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(SysUser user){
        Map<String,Object> map = new HashMap<>();
        try{
            userService.selectByName(user,map);
        }catch (Exception e){
            log.error("login",e);
            map.put("result","0");
            map.put("message","登陆异常");
        }
        return map;
    }

    @PostMapping("/update")
    @ResponseBody
    public Object update(Integer userId , SysUser sysUser){
        Map<String,Object> map = new HashMap<>();
        try {
            SysUser user = userService.selectById(userId);
            user.setName(sysUser.getName());
            user.setPassword(sysUser.getPassword());
            int row = userService.update(user);
            if(row <= 0){
                map.put("result","0");
                map.put("message","修改失败");
            }
            map.put("result","1");
            map.put("message","修改成功");
        }catch (Exception e){
            log.error("update",e);
            map.put("result","0");
            map.put("message","修改异常");
        }
        return map;
    }
}
