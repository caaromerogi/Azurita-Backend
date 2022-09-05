package com.azurita.azuritaweb.Security.Entity;

import com.azurita.azuritaweb.DTO.CartDTO;
import com.azurita.azuritaweb.Entity.Cart;
import com.azurita.azuritaweb.Entity.PurchaseOrder;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    @Column(nullable = false)
    private String dni;


    @ManyToMany
    @JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> role = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference(value = "customer-purchaseorder")
    private Set<PurchaseOrder> purchaseOrders = new HashSet<>();

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Customer(String name, String lastName, String email, String dni, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dni = dni;
        this.password = password;
    }
}
