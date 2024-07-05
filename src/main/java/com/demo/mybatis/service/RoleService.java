package com.demo.mybatis.service;

import com.demo.mybatis.domain.Role;

public interface RoleService {

    Role getRole(String roleName);

    void updateRole(Role role);

    void registerRole(Role role);

    void deleteRole(String roleName);
}
