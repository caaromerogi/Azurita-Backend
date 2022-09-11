package com.azurita.azuritaweb.DTO;

import com.azurita.azuritaweb.Security.enums.SizeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDTO {
    private Long productId;

    private Double price;

    private String imgPath;

    private String name;

    private Set<SizeDetailsDTO> sizeDetails = new HashSet<>();
}
