package com.demo.mybatis.repository;

import org.apache.ibatis.annotations.*;

import com.demo.mybatis.domain.Role;

public interface RoleRepository {

    @Results({@Result(property = "id", column = "id"), @Result(property = "username", column = "username"),
            @Result(property = "firstname", column = "firstname"), @Result(property = "lastname", column = "lastname"),
            @Result(property = "email", column = "email"),})
    @Select("SELECT id, username, password, firstname, lastname, email FROM role WHERE roleName = #{roleName}")
    Role getRoleByName(String roleName);

    @Insert("INSERT INTO role (username, password, firstname, lastname, email) VALUES (#{username}, #{password}, #{firstname}, #{lastname}, #{email})")
    void registerRole(Role role);

    @Update("UPDATE role SET firstname = #{firstname}, lastname = #{lastname}, email = #{email}, password = #{password} WHERE username = #{username}")
    void updateRole(Role role);

    @Delete("DELETE FROM role WHERE role_name = #{roleName}")
    void deleteRole(String roleName);
}