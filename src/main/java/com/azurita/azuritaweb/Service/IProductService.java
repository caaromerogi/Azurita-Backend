package com.azurita.azuritaweb.Service;

import com.azurita.azuritaweb.DTO.ProductDTO;
import com.azurita.azuritaweb.DTO.ResponseProductDTO;

import java.util.List;

public interface IProductService {

    public ResponseProductDTO createProduct(ProductDTO productDTO);

    public ResponseProductDTO getProductById(Long id);

    List<ResponseProductDTO> getAllProducts();

    ResponseProductDTO updateProduct(Long id, ProductDTO productDTO);

    void deleteProductById(Long id);


}
