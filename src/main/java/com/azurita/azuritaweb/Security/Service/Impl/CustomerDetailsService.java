package com.azurita.azuritaweb.Security.Service.Impl;

import com.azurita.azuritaweb.Security.Entity.Customer;
import com.azurita.azuritaweb.Security.Entity.MainCustomer;
import com.azurita.azuritaweb.Security.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService implements UserDetailsService {
    @Autowired
    ICustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerService.getByEmail(email).get();
        return MainCustomer.build(customer);
    }
}
