package com.azurita.azuritaweb.Security.DTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
public class NewCustomerDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @Email
    private String email;
    @NotBlank
    private String dni;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<String>();


}
