package com.azurita.azuritaweb.ID;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductId implements Serializable {
    private Long productId;
    private String size;
}
