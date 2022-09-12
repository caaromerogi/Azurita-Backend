package com.azurita.azuritaweb.DTO;

import com.azurita.azuritaweb.Entity.OrderDetails;
import com.azurita.azuritaweb.Security.Entity.Customer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class PurchaseOrderResponseDTO {

    private Long id;

    private String date;

//    @NotNull
//    @Column(nullable = false)
//    private Double total;

    @NotNull
    @Column(nullable = false)
    private String municipality;

    @NotNull
    @Column(nullable = false)
    private String address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "purchaseOrder")
    @JsonManagedReference(value = "purchase-orderdetails")
    private Set<OrderDetails> orderDetails = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
//    @JsonBackReference(value = "customer-purchaseorder")
    private Customer customer;
}
