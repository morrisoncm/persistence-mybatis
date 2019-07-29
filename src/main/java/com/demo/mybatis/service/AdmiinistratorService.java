package com.demo.mybatis.service;

import com.demo.mybatis.domain.Admiinistrator;

public interface AdmiinistratorService {

	Admiinistrator getAdmiinistrator(String username);

	void updateAdmiinistrator(Admiinistrator admiinistrator);

	void registerAdmiinistrator(Admiinistrator admiinistrator);

	void deleteAdmiinistrator(String username);
}