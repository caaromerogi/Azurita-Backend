package com.azurita.azuritaweb.DTO;

import com.azurita.azuritaweb.Security.enums.SizeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SizeDetailsDTO {
    private Long id;

    private Integer stock;

    private SizeName size;

    public SizeDetailsDTO(Integer stock, SizeName size) {
        this.stock = stock;
        this.size = size;
    }
}
