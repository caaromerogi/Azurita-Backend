package com.azurita.azuritaweb.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetails")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference(value = "purchase-orderdetails")
    @JoinColumn(name = "order_id")
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    //@JsonBackReference(value = "product-orderdetails")
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    @Column(nullable = false)
    private Double unitPrice;

    @NotNull
    @Column(nullable = false)
    private Integer quantity;
}
