package com.hpe.springboot_crud.dao;

import com.hpe.springboot_crud.model.SysUserRoleKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleMapper {
    @Delete({
        "delete from sys_user_role",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and role_id = #{roleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(SysUserRoleKey key);

    @Insert({
        "insert into sys_user_role (user_id, role_id)",
        "values (#{userId,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER})"
    })
    int insert(SysUserRoleKey record);

    int insertSelective(SysUserRoleKey record);
}