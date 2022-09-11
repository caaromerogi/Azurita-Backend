package com.azurita.azuritaweb.Security.Service.Impl;

import com.azurita.azuritaweb.Security.Repository.ICustomerRepository;
import com.azurita.azuritaweb.Security.DTO.CustomerDTO;
import com.azurita.azuritaweb.Security.Entity.Customer;
import com.azurita.azuritaweb.Security.Service.ICustomerService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    ModelMapper modelMapper;

    public Optional<Customer> getByEmail(String email){
        return customerRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email){
        return customerRepository.existsByEmail(email);
    }
    @Override
    @Transactional
    public Customer saveCustomer(Customer customerDTO){
        return customerRepository.save(customerDTO);
    }

    public String getHashedPassword(String email){
        if(!getByEmail(email).stream().findFirst().isPresent()){
            return null;
        }
        return getByEmail(email).stream().findFirst().get().getPassword();
    }
}
