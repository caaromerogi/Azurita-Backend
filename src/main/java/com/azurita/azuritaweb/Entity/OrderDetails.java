package com.azurita.azuritaweb.Entity;

import com.azurita.azuritaweb.Security.Entity.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "OrderDetails")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String productName;

    @NotNull
    @Column(nullable = false)
    private String size;

    @NotNull
    @Column(nullable = false)
    private Double total; //quantity*unitPrice

    @NotNull
    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private PurchaseOrder purchaseOrder;
}
