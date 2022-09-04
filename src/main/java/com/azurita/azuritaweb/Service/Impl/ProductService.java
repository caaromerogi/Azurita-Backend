package com.azurita.azuritaweb.Service.Impl;

import com.azurita.azuritaweb.DTO.ProductDTO;
import com.azurita.azuritaweb.Entity.Product;
import com.azurita.azuritaweb.Repository.IProductRepository;
import com.azurita.azuritaweb.Service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return modelMapper.map(productRepository.save(modelMapper.map(productDTO, Product.class)), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getProductById(Long id) {

        return productRepository.findByProductId(id)
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
