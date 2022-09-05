package com.azurita.azuritaweb.Security.Service.Impl;

import com.azurita.azuritaweb.Security.Entity.Role;
import com.azurita.azuritaweb.Security.Repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService {
    @Autowired
    IRoleRepository roleRepository;

    public Optional<Role> getByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
