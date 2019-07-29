package com.demo.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.demo.mybatis.domain.Admiinistrator;
import com.demo.mybatis.exception.AdmiinistratorFoundException;
import com.demo.mybatis.exception.AdmiinistratorNotFoundException;
import com.demo.mybatis.repository.AdmiinistratorRepository;
import com.demo.mybatis.service.AdmiinistratorService;

@Service
public class AdmiinistratorrServiceImpl implements AdmiinistratorService {

	@Autowired
	private AdmiinistratorRepository administatorRepository;

	@Override
	public Admiinistrator getAdmiinistrator(String username) {
		Admiinistrator admiinistratorFromDb = administatorRepository.getAdmiinistrator(username);
		if (ObjectUtils.isEmpty(admiinistratorFromDb)) {
			throw new AdmiinistratorNotFoundException();
		}
		return admiinistratorFromDb;
	}

	@Override
	public void updateAdmiinistrator(Admiinistrator admiinistrator) {
		Admiinistrator admiinistratorFromDb = getAdmiinistrator(admiinistrator.getUsername());
		if (!admiinistratorFromDb.equals(admiinistrator)) {
			administatorRepository.updateAdmiinistrator(admiinistrator);
		}
	}

	@Override
	public void registerAdmiinistrator(Admiinistrator admiinistrator) {
		if (!ObjectUtils.isEmpty(administatorRepository.getAdmiinistrator(admiinistrator.getUsername()))) {
			throw new AdmiinistratorFoundException();
		}
		administatorRepository.registerAdmiinistrator(admiinistrator);
	}

	@Override
	public void deleteAdmiinistrator(String username) {
		getAdmiinistrator(username);
		administatorRepository.deleteAdmiinistrator(username);
	}
}