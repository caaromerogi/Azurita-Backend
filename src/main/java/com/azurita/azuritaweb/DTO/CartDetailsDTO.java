package com.azurita.azuritaweb.DTO;

import com.azurita.azuritaweb.Entity.Cart;
import com.azurita.azuritaweb.Entity.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDetailsDTO {

    private Long id;

    private Long productId;

    private String size;

    private Long cartId;

    private Double unitPrice;

    private Integer quantity;
}
