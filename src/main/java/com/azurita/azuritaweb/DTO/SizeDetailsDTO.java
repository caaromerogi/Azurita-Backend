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

    private SizeName sizeName;

    public SizeDetailsDTO(SizeName sizeName) {
        this.sizeName = sizeName;
    }
}
