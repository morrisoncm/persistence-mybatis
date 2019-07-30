package com.demo.mybatis.service;

import com.demo.mybatis.domain.Administrator;

public interface AdministratorService {

	Administrator getAdministrator(String username);

	void updateAdministrator(Administrator administrator);

	void registerAdministrator(Administrator administrator);

	void deleteAdministrator(String username);
}