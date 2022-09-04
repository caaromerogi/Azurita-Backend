package com.azurita.azuritaweb.Entity;

import com.azurita.azuritaweb.ID.ProductId;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@IdClass(ProductId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private ProductId productId;

    @NotNull
    private Double price;

    @NotNull
    private Integer stock;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "product")
    @JsonManagedReference
    private Set<CartDetails> cartDetails;

    @OneToOne
    @JoinColumn(name = "product_details_id")
    private ProductDetails productDetails;
}
