package com.azurita.azuritaweb.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetails")
@Data
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "order_id")
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    @JsonBackReference
    @MapsId("productId")
    @JoinColumns({
            @JoinColumn(name = "product_id"),
            @JoinColumn(name = "size")
    })
    private Product product;

    @NotNull
    @Column(nullable = false)
    private Double unitPrice;

    @NotNull
    @Column(nullable = false)
    private Integer quantity;
}
