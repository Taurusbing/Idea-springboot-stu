package com.hpe.springboot_crud.dao;

import com.hpe.springboot_crud.model.SysRole;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SysRoleMapper {
    @Delete({
        "delete from sys_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_role (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(SysRole record);

    int insertSelective(SysRole record);

    @Select({
        "select",
        "id, name",
        "from sys_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.hpe.springboot_crud.dao.SysRoleMapper.BaseResultMap")
    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    @Update({
        "update sys_role",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysRole record);
}