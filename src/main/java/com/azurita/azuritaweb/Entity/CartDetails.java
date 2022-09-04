package com.azurita.azuritaweb.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CartDetails")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("productId")
    @JsonBackReference(value = "product-cartdetails")
    @JoinColumns({
            @JoinColumn(name = "product_id"),
            @JoinColumn(name = "size")
    })
    private Product product;

    @ManyToOne
    @JsonBackReference(value = "cart-cartdetails")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @NotNull
    @Column(nullable = false)
    private Double unitPrice;

    @NotNull
    @Column(nullable = false)
    private Integer quantity;

}
