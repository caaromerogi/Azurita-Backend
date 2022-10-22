package com.azurita.azuritaweb.Entity;

import com.azurita.azuritaweb.Security.Entity.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purchase_order")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseOrderId;

    @NotNull
    @Column(nullable = false)
    private String date;

    private Double total;

    @NotNull
    @Column(nullable = false)
    private String municipality;

    @NotNull
    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


}
