package com.azurita.azuritaweb.DTO;

import com.azurita.azuritaweb.Entity.Product;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDetailsDTO {
    private Long id;

    private String imgPath;

    private String description;

    private Long productId;

}
