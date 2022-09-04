package com.azurita.azuritaweb.Entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "ProductDetails")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String imgPath;

    @NotNull
    @Column(nullable = false)
    private String description;

    @MapsId("productId")
    @OneToOne(mappedBy = "productDetails")
    @JoinColumns({
            @JoinColumn(name = "product_id"),
            @JoinColumn(name = "size")
    })
    private Product product;
}
