package com.azurita.azuritaweb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private Long productId;

    private Double price;

    private String imgPath;

    private String name;

    private Set<String> sizes = new HashSet<>();


}
