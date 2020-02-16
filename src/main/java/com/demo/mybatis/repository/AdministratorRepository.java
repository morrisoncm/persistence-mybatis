package com.demo.mybatis.repository;

import org.apache.ibatis.annotations.*;

import com.demo.mybatis.domain.Administrator;

public interface AdministratorRepository {

	@Results({ @Result(property = "id", column = "id"), @Result(property = "username", column = "username"),
			@Result(property = "firstname", column = "firstname"), @Result(property = "lastname", column = "lastname"),
			@Result(property = "email", column = "email"), })
	@Select("SELECT id, username, password, firstname, lastname, email FROM administrator WHERE username = #{username}")
	Administrator getAdministratorbyUsername(String username);

	@Insert("INSERT INTO administrator (username, password, firstname, lastname, email) VALUES (#{username}, #{password}, #{firstname}, #{lastname}, #{email})")
	void registerAdministrator(Administrator administator);

	@Update("UPDATE administrator SET firstname = #{firstname}, lastname = #{lastname}, email = #{email}, password = #{password} WHERE username = #{username}")
	void updateAdministrator(Administrator administator);

	@Delete("DELETE FROM administrator WHERE username = #{username}")
	void deleteAdministrator(String username);
}