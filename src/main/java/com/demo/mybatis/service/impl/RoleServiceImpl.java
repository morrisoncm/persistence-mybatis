package com.demo.mybatis.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.demo.mybatis.domain.Role;
import com.demo.mybatis.repository.RoleRepository;
import com.demo.mybatis.service.RoleService;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public Role getRole(String roleName) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            RoleRepository roleRepository = session.getMapper(RoleRepository.class);
            Role roleFromDatabase = roleRepository.getRoleByName(roleName);
            if (ObjectUtils.isEmpty(roleFromDatabase)) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Role does not exist!");
            }
            return roleFromDatabase;
        }
    }

    @Override
    public void updateRole(Role role) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            RoleRepository roleRepository = session.getMapper(RoleRepository.class);
            Role roleFromDatabase = getRole(role.getRoleName());
            if (!roleFromDatabase.equals(role)) {
                roleRepository.updateRole(role);
                session.commit();
            }
        }
    }

    @Override
    public void registerRole(Role role) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            RoleRepository roleRepository = session.getMapper(RoleRepository.class);
            if (!ObjectUtils.isEmpty(roleRepository.getRoleByName(role.getRoleName()))) {
                throw new ResponseStatusException(
                        HttpStatus.FORBIDDEN, "Role already exists!");
            }
            roleRepository.registerRole(role);
            session.commit();
        }

    }

    @Override
    public void deleteRole(String roleName) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            RoleRepository roleRepository = session.getMapper(RoleRepository.class);
            getRole(roleName);
            roleRepository.deleteRole(roleName);
            session.commit();
        }
    }
}