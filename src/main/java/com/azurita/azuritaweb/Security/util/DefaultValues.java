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
public class DefaultValues implements CommandLineRunner {

    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    ISizeDetailsRepository sizeRepository;

    @Override
    public void run(String... args) throws Exception {

        if(roleRepository.findByRoleName(RoleName.ROLE_ADMIN).isEmpty()){
            Role rolAdmin = new Role(RoleName.ROLE_ADMIN);
            roleRepository.save(rolAdmin);
        }

        if(roleRepository.findByRoleName(RoleName.ROLE_USER).isEmpty()){
            Role rolUSer = new Role(RoleName.ROLE_USER);
            roleRepository.save(rolUSer);
        }

        if(sizeRepository.findBySize(SizeName.XS).isEmpty()){
            SizeDetails sizeXS = new SizeDetails(SizeName.XS);
            sizeRepository.save(sizeXS);
        }

        if(sizeRepository.findBySize(SizeName.S).isEmpty()){
            SizeDetails sizeS = new SizeDetails(SizeName.S);
            sizeRepository.save(sizeS);
        }

        if(sizeRepository.findBySize(SizeName.M).isEmpty()){
            SizeDetails sizeM = new SizeDetails(SizeName.M);
            sizeRepository.save(sizeM);
        }

        if(sizeRepository.findBySize(SizeName.L).isEmpty()){
            SizeDetails sizeL = new SizeDetails(SizeName.L);
            sizeRepository.save(sizeL);
        }

        if(sizeRepository.findBySize(SizeName.XL).isEmpty()){
            SizeDetails sizeXL = new SizeDetails(SizeName.XL);
            sizeRepository.save(sizeXL);
        }

        if(sizeRepository.findBySize(SizeName.XXL).isEmpty()){
            SizeDetails sizeXXL = new SizeDetails(SizeName.XXL);
            sizeRepository.save(sizeXXL);
        }

        //TODO Create default admin email
    }
}
