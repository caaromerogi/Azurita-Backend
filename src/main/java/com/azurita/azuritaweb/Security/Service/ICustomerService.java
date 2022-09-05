package com.azurita.azuritaweb.Security.Service;

import com.azurita.azuritaweb.Security.DTO.CustomerDTO;
import com.azurita.azuritaweb.Security.Entity.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ICustomerService {

    public CustomerDTO createCustomer(CustomerDTO customerDTO);

    public Optional<Customer> getByEmail(String email);

    public boolean existsByEmail(String email);
}
