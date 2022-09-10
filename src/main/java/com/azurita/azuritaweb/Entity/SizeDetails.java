package com.azurita.azuritaweb.Entity;

import com.azurita.azuritaweb.Security.enums.SizeName;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SizeDetails")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SizeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SizeName size;

    @NotNull
    @Column(nullable = false)
    private Integer stock;

    public SizeDetails(SizeName size, Integer stock) {
        this.size = size;
        this.stock = stock;
    }
}
