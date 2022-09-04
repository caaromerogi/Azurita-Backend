package com.azurita.azuritaweb.DTO;

import com.azurita.azuritaweb.Entity.CartDetails;
import com.azurita.azuritaweb.Security.Entity.Customer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDTO {
    private Long id;

    private Long customerId;

    private Set<CartDetailsDTO> cartDetailsDTO = new HashSet<>();
}
