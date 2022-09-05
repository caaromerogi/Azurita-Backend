package com.azurita.azuritaweb.Security.util;

import com.azurita.azuritaweb.Security.Entity.Role;
import com.azurita.azuritaweb.Security.Repository.IRoleRepository;
import com.azurita.azuritaweb.Security.enums.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class TIl implements CommandLineRunner {

    @Autowired
    IRoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
//        Role rolAdmin = new Role(RoleName.ROLE_ADMIN);
//        Role rolUSer = new Role(RoleName.ROLE_USER);
//        roleRepository.save(rolAdmin);
//        roleRepository.save(rolUSer);
    }
}
