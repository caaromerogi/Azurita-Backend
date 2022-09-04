package com.azurita.azuritaweb.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CartDetails")
@Data
public class CartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("productId")
    @JsonBackReference
    @JoinColumns({
            @JoinColumn(name = "product_id"),
            @JoinColumn(name = "size")
    })
    private Product product;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @NotNull
    @Column(nullable = false)
    private Double unitPrice;

    @NotNull
    @Column(nullable = false)
    private Integer quantity;

}
