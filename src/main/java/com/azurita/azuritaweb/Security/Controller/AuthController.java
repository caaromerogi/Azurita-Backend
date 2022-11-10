package com.azurita.azuritaweb.Security.Controller;

import com.azurita.azuritaweb.DTO.MessageDTO;
import com.azurita.azuritaweb.Security.DTO.*;
import com.azurita.azuritaweb.Security.Entity.Customer;
import com.azurita.azuritaweb.Security.Entity.Role;
import com.azurita.azuritaweb.Security.JWT.JwtProvider;
import com.azurita.azuritaweb.Security.Service.ICustomerService;
import com.azurita.azuritaweb.Security.Service.Impl.CustomerService;
import com.azurita.azuritaweb.Security.Service.Impl.RoleService;
import com.azurita.azuritaweb.Security.enums.RoleName;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomerService customerService;

    @Autowired
    RoleService roleService;

    @Autowired
    JwtProvider jwtProvider;


    @PostMapping("/customerRegister")
    public ResponseEntity<?> newCustomer(@Valid @RequestBody NewCustomerDTO newCustomerDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new MessageDTO("Campos errados"),HttpStatus.BAD_REQUEST);
        }
        if(customerService.existsByEmail(newCustomerDTO.getEmail())){
            return new ResponseEntity<>(new MessageDTO("El email ingresado ya existe"), HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer(newCustomerDTO.getName(), newCustomerDTO.getLastName(),
                newCustomerDTO.getEmail(),
                newCustomerDTO.getDni(),
                passwordEncoder.encode(newCustomerDTO.getPassword())
                );
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RoleName.ROLE_USER));
        if(newCustomerDTO.getRoles().contains("admin")){
            roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN));
        }

        customer.setRole(roles);
        customerService.saveCustomer(customer);

        return new ResponseEntity<>(new MessageDTO("Usuario creado con éxito"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@Valid @RequestBody LoginCustomerDTO loginCustomerDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(new MessageDTO("Campos errados"), HttpStatus.BAD_REQUEST);
        }
        if(customerService.getHashedPassword(loginCustomerDTO.getEmail())==null){
            return new ResponseEntity<>(new MessageDTO("El email no existe o no concuerda con la contraseña ingresada"),
                    HttpStatus.BAD_REQUEST);
        }

        if(passwordEncoder.matches(loginCustomerDTO.getPassword(),customerService.getHashedPassword(loginCustomerDTO.getEmail()))){
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginCustomerDTO.getEmail(),loginCustomerDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            JwtDTO jwtDTO = new JwtDTO(customerService.getByEmail(loginCustomerDTO.getEmail()).get().getCustomerId(), jwt, userDetails.getUsername(), userDetails.getAuthorities());
            return new ResponseEntity<>(jwtDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(new MessageDTO("Contraseña errada"), HttpStatus.BAD_REQUEST);
    }
}
