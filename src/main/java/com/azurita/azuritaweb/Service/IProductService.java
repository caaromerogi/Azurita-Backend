package com.azurita.azuritaweb.Service;

import com.azurita.azuritaweb.DTO.ProductDTO;

import java.util.List;

public interface IProductService {

    public ProductDTO createProduct(ProductDTO productDTO);

    public List<ProductDTO> getProductById(Long id);
}
