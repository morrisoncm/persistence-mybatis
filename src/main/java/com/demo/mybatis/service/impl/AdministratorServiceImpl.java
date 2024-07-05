package com.demo.mybatis.service.impl;

import jakarta.transaction.Transactional;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.demo.mybatis.domain.Administrator;
import com.demo.mybatis.repository.AdministratorRepository;
import com.demo.mybatis.service.AdministratorService;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    @Transactional
    public Administrator getAdministrator(String username) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdministratorRepository administatorRepository = session.getMapper(AdministratorRepository.class);
            Administrator administratorFromDb = administatorRepository.getAdministratorbyUsername(username);
            if (ObjectUtils.isEmpty(administratorFromDb)) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Administrator does not exist!");
            }
            return administratorFromDb;
        }
    }

    @Override
    @Transactional
    public void updateAdministrator(Administrator administrator) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdministratorRepository administatorRepository = session.getMapper(AdministratorRepository.class);
            Administrator administratorFromDb = getAdministrator(administrator.getUsername());
            if (!administratorFromDb.equals(administrator)) {
                administatorRepository.updateAdministrator(administrator);
                session.commit();
            }
        }
    }

    @Override
    @Transactional
    public void registerAdministrator(Administrator administrator) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdministratorRepository administatorRepository = session.getMapper(AdministratorRepository.class);
            if (!ObjectUtils.isEmpty(administatorRepository.getAdministratorbyUsername(administrator.getUsername()))) {
                throw new ResponseStatusException(
                        HttpStatus.FORBIDDEN, "Administrator already exists");
            }
            administatorRepository.registerAdministrator(administrator);
            session.commit();
        }
    }

    @Override
    @Transactional
    public void deleteAdministrator(String username) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AdministratorRepository administatorRepository = session.getMapper(AdministratorRepository.class);
            getAdministrator(username);
            administatorRepository.deleteAdministrator(username);
            session.commit();
        }
    }
}