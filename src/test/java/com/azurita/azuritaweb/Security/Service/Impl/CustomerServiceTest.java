package com.azurita.azuritaweb.Security.Service.Impl;

import com.azurita.azuritaweb.Security.Entity.Customer;
import com.azurita.azuritaweb.Security.Entity.Role;
import com.azurita.azuritaweb.Security.Repository.ICustomerRepository;
import com.azurita.azuritaweb.Security.enums.RoleName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    CustomerService customerService;

    @Mock
    ICustomerRepository customerRepository;

    @BeforeEach
    void init(){
        customerService = new CustomerService(customerRepository);
    }

    @Test
    void getByEmail() {
        Customer customerTest = new Customer();
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(RoleName.ROLE_USER));
        customerTest.setCustomerId(1L);
        customerTest.setRole(roles);
        customerTest.setEmail("caaromerogi@unal.edu.co");
        customerTest.setName("Carlos");
        customerTest.setDni("1037671544");
        customerTest.setLastName("Romero");
        customerTest.setPassword("123456789");
        Optional<Customer> optionalCustomerAnswer = Optional.of(customerTest);

        Mockito.when(customerRepository.findByEmail(Mockito.any(String.class))).thenReturn(optionalCustomerAnswer);

        Optional<Customer> optionalCustomer= customerService.getByEmail("caaromerogi@unal.edu.co");

        Assertions.assertEquals(optionalCustomer.get(), optionalCustomerAnswer.get());

    }

    @Test
    void existsByEmail() {
        Customer customerTest = new Customer();
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(RoleName.ROLE_USER));
        customerTest.setCustomerId(1L);
        customerTest.setRole(roles);
        customerTest.setEmail("caaromerogi@unal.edu.co");
        customerTest.setName("Carlos");
        customerTest.setDni("1037671544");
        customerTest.setLastName("Romero");
        customerTest.setPassword("123456789");

        Mockito.when(customerRepository.existsByEmail("caaromerogi@unal.edu.co")).thenReturn(true);
        Mockito.when(customerRepository.existsByEmail("carlosantonio_1234@outlook.es")).thenReturn(false);

        boolean customerExists = customerService.existsByEmail("caaromerogi@unal.edu.co");
        boolean customerDoesntExist = customerService.existsByEmail("carlosantonio_1234@outlook.es");

        Assertions.assertTrue(customerExists);
        Assertions.assertFalse(customerDoesntExist);

    }

    @Test
    void saveCustomer() {
        Customer customerTest = new Customer();
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(RoleName.ROLE_USER));
        customerTest.setCustomerId(1L);
        customerTest.setRole(roles);
        customerTest.setEmail("caaromerogi@unal.edu.co");
        customerTest.setName("Carlos");
        customerTest.setDni("1037671544");
        customerTest.setLastName("Romero");
        customerTest.setPassword("123456789");
        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customerTest);

        Customer customer = customerService.saveCustomer(customerTest);

        Assertions.assertEquals(customerTest, customer);
    }

    @Test
    void getHashedPassword() {
        Customer customerTest = new Customer();
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(RoleName.ROLE_USER));
        customerTest.setCustomerId(1L);
        customerTest.setRole(roles);
        customerTest.setEmail("caaromerogi@unal.edu.co");
        customerTest.setName("Carlos");
        customerTest.setDni("1037671544");
        customerTest.setLastName("Romero");
        customerTest.setPassword("123456789");

        Optional<Customer> customerOptional = Optional.of(customerTest);

        Mockito.when(customerRepository.findByEmail(Mockito.any(String.class))).thenReturn(customerOptional);

        String hashedPassword = customerService.getHashedPassword("caaromerogi@unal.edu.co");

        Assertions.assertEquals(hashedPassword, customerTest.getPassword());

    }
}