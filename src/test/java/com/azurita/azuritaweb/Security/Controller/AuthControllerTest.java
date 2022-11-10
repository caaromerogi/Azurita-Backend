package com.azurita.azuritaweb.Security.Controller;

import com.azurita.azuritaweb.Security.DTO.CustomerDTO;
import com.azurita.azuritaweb.Security.DTO.RoleDTO;
import com.azurita.azuritaweb.Security.Entity.Customer;
import com.azurita.azuritaweb.Security.Entity.Role;
import com.azurita.azuritaweb.Security.JWT.JwtProvider;
import com.azurita.azuritaweb.Security.Service.Impl.CustomerService;
import com.azurita.azuritaweb.Security.Service.Impl.RoleService;
import com.azurita.azuritaweb.Security.enums.RoleName;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
class AuthControllerTest {

    @MockBean
    CustomerService customerService;

    ObjectMapper mapper =  new ObjectMapper();

    @MockBean
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    MockMvc mockMvc;


    @Test
    void newCustomer() throws Exception {
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

        CustomerDTO customerDTO = new CustomerDTO();
        Set<RoleDTO> rolesDTO=new HashSet<>();
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleName(RoleName.ROLE_USER);
        rolesDTO.add(roleDTO);
        customerDTO.setId(1L);
        customerDTO.setName("Carlos");
        customerDTO.setEmail("caaromerogi@unal.edu.co");
        customerDTO.setDni("1037671544");
        customerDTO.setPassword("123456789");
        customerDTO.setRole(rolesDTO);
        customerDTO.setLastName("Romero");

        Mockito.when(customerService.saveCustomer(Mockito.any(Customer.class))).thenReturn(customerTest);

        mockMvc.perform(post("/auth/customerRegister")
                .content(mapper.writeValueAsString(customerDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    void login() {
    }
}