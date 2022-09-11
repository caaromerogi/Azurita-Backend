package com.azurita.azuritaweb.Security.Service.Impl;

import com.azurita.azuritaweb.Security.Entity.Role;
import com.azurita.azuritaweb.Security.Repository.IRoleRepository;
import com.azurita.azuritaweb.Security.enums.RoleName;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {
    @Autowired
    IRoleRepository roleRepository;

    public Role getByRoleName(RoleName roleName) {
        if (roleRepository.findByRoleName(roleName).isPresent()) {
            return roleRepository.findByRoleName(roleName).get();
        }
        return null;
    }

    public Role save(RoleName roleName){
        return roleRepository.save(new Role(roleName));
    }
}
