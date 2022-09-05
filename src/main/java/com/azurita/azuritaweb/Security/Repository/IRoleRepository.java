package com.azurita.azuritaweb.Security.Repository;

import com.azurita.azuritaweb.Security.DTO.RoleDTO;
import com.azurita.azuritaweb.Security.Entity.Role;
import com.azurita.azuritaweb.Security.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
