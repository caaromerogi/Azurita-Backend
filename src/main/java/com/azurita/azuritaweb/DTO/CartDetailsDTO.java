package com.azurita.azuritaweb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDetailsDTO {

    private Long id;

    private Long productId;

    private String size;

    private Long customerId;

    private Integer quantity;
}
