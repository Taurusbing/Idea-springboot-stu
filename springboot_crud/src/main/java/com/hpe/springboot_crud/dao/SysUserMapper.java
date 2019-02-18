package com.hpe.springboot_crud.dao;

import com.hpe.springboot_crud.model.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SysUserMapper {
    @Delete({
        "delete from sys_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_user (id, name, ",
        "password)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR})"
    })
    int insert(SysUser record);

    int insertSelective(SysUser record);

    @Select({
        "select",
        "id, name, password",
        "from sys_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.hpe.springboot_crud.dao.SysUserMapper.BaseResultMap")
    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    @Update({
        "update sys_user",
        "set name = #{name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysUser record);

    List<SysUser> queryAll();

    int addUser(SysUser user);

    SysUser selectByName(String record);

    int updateById(SysUser user);
}