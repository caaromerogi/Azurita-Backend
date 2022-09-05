package com.azurita.azuritaweb.Security.DTO;

import com.azurita.azuritaweb.DTO.PurchaseOrderDTO;
import com.azurita.azuritaweb.Entity.PurchaseOrder;
import com.azurita.azuritaweb.Security.Entity.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String dni;

    private Set<RoleDTO> role = new HashSet<>();

    private Set<PurchaseOrderDTO> purchaseOrders = new HashSet<>();

    public CustomerDTO(String name, String lastName, String email, String password, String dni) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dni = dni;
    }
}
