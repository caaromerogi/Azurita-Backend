package com.azurita.azuritaweb.Security.Service.Impl;

import com.azurita.azuritaweb.Repository.ICustomerRepository;
import com.azurita.azuritaweb.Security.DTO.CustomerDTO;
import com.azurita.azuritaweb.Security.Entity.Customer;
import com.azurita.azuritaweb.Security.Service.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        Customer saved = customerRepository.save(customer);
        CustomerDTO newDTO = modelMapper.map(saved, CustomerDTO.class);
        return newDTO;
    }
}
