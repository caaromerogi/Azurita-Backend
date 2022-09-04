package com.azurita.azuritaweb.DTO;

import com.azurita.azuritaweb.Entity.CartDetails;
import com.azurita.azuritaweb.Entity.ProductDetails;
import com.azurita.azuritaweb.ID.ProductId;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private Long productId;

    private String size;

    private Double price;

    private Integer stock;

    private Set<CartDetailsDTO> cartDetails = new HashSet<>();

    private Long productDetailsId;

    private Set<OrderDetailsDTO> orderDetailsDTO = new HashSet<>();

}
