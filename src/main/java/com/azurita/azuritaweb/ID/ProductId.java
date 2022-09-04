package com.azurita.azuritaweb.ID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Embeddable
public class ProductId implements Serializable {
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private String size;
}
