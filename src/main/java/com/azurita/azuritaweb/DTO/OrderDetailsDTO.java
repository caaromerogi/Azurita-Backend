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

    private Long productId;

    private String size;

    private String productName;

    private Long purchaseOrderId;

    private Double total;

    private Integer quantity;
}
