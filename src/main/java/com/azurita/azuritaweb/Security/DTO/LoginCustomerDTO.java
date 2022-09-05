package com.azurita.azuritaweb.Security.DTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginCustomerDTO {
    @Email
    private String email;
    @NotBlank
    private String password;
}
