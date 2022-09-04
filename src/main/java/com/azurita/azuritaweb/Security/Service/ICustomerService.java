package com.azurita.azuritaweb.Security.Service;

import com.azurita.azuritaweb.Security.DTO.CustomerDTO;
import org.springframework.stereotype.Service;


public interface ICustomerService {

    public CustomerDTO createCustomer(CustomerDTO customerDTO);
}
