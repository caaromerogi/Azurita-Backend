package com.azurita.azuritaweb.DTO;

import com.azurita.azuritaweb.Entity.PurchaseOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailsDTO {
    private Long id;

    private PurchaseOrder purchaseOrder;

    private Long productId;

    private String size;

    private Double unitPrice;

    private Integer quantity;
}
