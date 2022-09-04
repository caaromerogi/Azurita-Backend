package com.azurita.azuritaweb.Entity;

import javax.persistence.*;

@Entity
@Table(name = "ProductDetails")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imgPath;

    private String description;

    @OneToOne(mappedBy = "productDetails")
    private Product product;
}
