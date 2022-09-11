package com.azurita.azuritaweb.Security.util;

import com.azurita.azuritaweb.Entity.SizeDetails;
import com.azurita.azuritaweb.Repository.ISizeDetailsRepository;
import com.azurita.azuritaweb.Security.Entity.Role;
import com.azurita.azuritaweb.Security.Repository.IRoleRepository;
import com.azurita.azuritaweb.Security.enums.RoleName;
import com.azurita.azuritaweb.Security.enums.SizeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class TIl implements CommandLineRunner {

    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    ISizeDetailsRepository sizeRepository;

    @Override
    public void run(String... args) throws Exception {
//        Role rolAdmin = new Role(RoleName.ROLE_ADMIN);
//        Role rolUSer = new Role(RoleName.ROLE_USER);
//        roleRepository.save(rolAdmin);
//        roleRepository.save(rolUSer);
//        SizeDetails sizeXS = new SizeDetails(SizeName.XS);
//        SizeDetails sizeS = new SizeDetails(SizeName.S);
//        SizeDetails sizeM = new SizeDetails(SizeName.M);
//        SizeDetails sizeL = new SizeDetails(SizeName.L);
//        SizeDetails sizeXL = new SizeDetails(SizeName.XL);
//        SizeDetails sizeXXL = new SizeDetails(SizeName.XXL);
//
//        sizeRepository.save(sizeXS);
//        sizeRepository.save(sizeS);
//        sizeRepository.save(sizeM);
//        sizeRepository.save(sizeL);
//        sizeRepository.save(sizeXL);
//        sizeRepository.save(sizeXXL);


    }
}
