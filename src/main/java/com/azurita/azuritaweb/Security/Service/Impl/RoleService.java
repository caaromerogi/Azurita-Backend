package com.azurita.azuritaweb.Security.Service.Impl;

import com.azurita.azuritaweb.Security.DTO.RoleDTO;
import com.azurita.azuritaweb.Security.Entity.Role;
import com.azurita.azuritaweb.Security.Repository.IRoleRepository;
import com.azurita.azuritaweb.Security.enums.RoleName;
import com.azurita.azuritaweb.Service.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Autowired
    ModelMapper modelMapper;

    public RoleDTO getByRoleName(RoleName roleName) {
        if (roleRepository.findByRoleName(roleName).isPresent()) {
            return modelMapper.map(roleRepository.findByRoleName(roleName).get(), RoleDTO.class);
        }
        return null;
    }

    public Role save(RoleName roleName){
        return roleRepository.save(new Role(roleName));
    }
}
