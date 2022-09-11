package com.azurita.azuritaweb.Security.Service;

import com.azurita.azuritaweb.Security.DTO.CustomerDTO;
import com.azurita.azuritaweb.Security.Entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface ICustomerService {

    public Customer saveCustomer(Customer customerDTO);

    public Optional<Customer> getByEmail(String email);

    public boolean existsByEmail(String email);
}
