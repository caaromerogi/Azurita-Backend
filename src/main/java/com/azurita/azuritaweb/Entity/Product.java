package com.azurita.azuritaweb.Entity;

import com.azurita.azuritaweb.ID.ProductId;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @EmbeddedId
    private ProductId productId;

    @NotNull
    @Column(nullable = false)
    private Double price;

    @NotNull
    @Column(nullable = false)
    private Integer stock;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "product")
    @JsonManagedReference(value = "product-cartdetails")
    private Set<CartDetails> cartDetails = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private ProductDetails productDetails;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonManagedReference(value = "product-orderdetails")
    private Set<OrderDetails> orderDetails = new HashSet<>();
}
