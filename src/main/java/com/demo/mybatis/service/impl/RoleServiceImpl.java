package com.demo.mybatis.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.demo.mybatis.domain.Role;
import com.demo.mybatis.exception.RoleFoundException;
import com.demo.mybatis.exception.RoleNotFoundException;
import com.demo.mybatis.repository.RoleRepository;
import com.demo.mybatis.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public Role getRole(String roleName) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			RoleRepository roleRepository = session.getMapper(RoleRepository.class);
			Role roleFromDb = roleRepository.getRoleByName(roleName);
			if (ObjectUtils.isEmpty(roleFromDb)) {
				throw new RoleNotFoundException();
			}
			return roleFromDb;
		}
	}

	@Override
	public void updateRole(Role role) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			RoleRepository roleRepository = session.getMapper(RoleRepository.class);
			Role roleFromDb = getRole(role.getRoleName());
			if (!roleFromDb.equals(role)) {
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
				throw new RoleFoundException();
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