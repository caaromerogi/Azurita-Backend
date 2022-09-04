package com.azurita.azuritaweb.Security.Entity;

import com.azurita.azuritaweb.Security.enums.RoleName;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

}
