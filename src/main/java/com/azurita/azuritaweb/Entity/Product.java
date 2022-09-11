package com.azurita.azuritaweb.Entity;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotNull
    @Column(nullable = false)
    private Double price;

    @NotNull
    @Column(nullable = false)
    private String imgPath;

    @NotNull
    @Column(nullable = false)
    private String name;

//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "product")
//    @JsonManagedReference(value = "product-cartdetails")
//    private Set<CartDetails> cartDetails = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "product_size", joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "size_id"))
    private Set<SizeDetails> sizeDetails = new HashSet<>();

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//    @JsonManagedReference(value = "product-orderdetails")
//    private Set<OrderDetails> orderDetails = new HashSet<>();
}
