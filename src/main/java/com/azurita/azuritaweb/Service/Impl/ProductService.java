package com.azurita.azuritaweb.Service.Impl;

import com.azurita.azuritaweb.DTO.ProductDTO;
import com.azurita.azuritaweb.DTO.ResponseProductDTO;
import com.azurita.azuritaweb.DTO.SizeDetailsDTO;
import com.azurita.azuritaweb.Entity.Product;
import com.azurita.azuritaweb.Entity.SizeDetails;
import com.azurita.azuritaweb.Repository.ICartDetailsRepository;
import com.azurita.azuritaweb.Repository.IProductRepository;
import com.azurita.azuritaweb.Repository.IPurchaseOrderRepository;
import com.azurita.azuritaweb.Repository.ISizeDetailsRepository;
import com.azurita.azuritaweb.Security.enums.SizeName;
import com.azurita.azuritaweb.Service.IOrderDetailsService;
import com.azurita.azuritaweb.Service.IProductService;
import com.azurita.azuritaweb.Service.IPurchaseOrderService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Autowired
    IOrderDetailsService orderDetailsService;

    @Autowired
    ISizeDetailsRepository sizeRepository;

    @Autowired
    ICartDetailsRepository cartDetailsRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @Override
    public ResponseProductDTO createProduct(ProductDTO productDTO) {
        Set<String> sizes = productDTO.getSizes();
        Product product = modelMapper.map(productDTO, Product.class);
        product.setImgPath(productDTO.getImgPath());
        Set<SizeDetails> sizeDetails = new HashSet<>();
        if(sizes.contains("XS"))
            sizeDetails.add(sizeRepository.findBySize(SizeName.XS).get());
        if(sizes.contains("S"))
            sizeDetails.add(sizeRepository.findBySize(SizeName.S).get());
        if(sizes.contains("M"))
            sizeDetails.add(sizeRepository.findBySize(SizeName.M).get());
        if(sizes.contains("L"))
            sizeDetails.add(sizeRepository.findBySize(SizeName.L).get());
        if(sizes.contains("XL"))
            sizeDetails.add(sizeRepository.findBySize(SizeName.XL).get());
        if (sizes.contains("XXL"))
            sizeDetails.add(sizeRepository.findBySize(SizeName.XXL).get());

        product.setSizeDetails(sizeDetails);
        return modelMapper.map(productRepository.save(product), ResponseProductDTO.class);
    }

    @Override
    public ResponseProductDTO getProductById(Long id) {
        return modelMapper.map(productRepository.findById(id).get(), ResponseProductDTO.class);

    }

    @Override
    public List<ResponseProductDTO> getAllProducts(){
        return productRepository.findAll().stream().map(product -> modelMapper.map(product, ResponseProductDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public ResponseProductDTO updateProduct(Long id, ProductDTO productDTO) {
        //GET PRODUCT TO CHECK IF EXISTS (OBVIOUSLY EXISTS) THEN CHANGE THE FIELDS
        return null;
    }

    @Transactional
    @Override
    public void deleteProductById(Long id) {
        cartDetailsRepository.deleteByProductId(id);
        sizeRepository.deleteProductSizeById(id);
        orderDetailsService.updateOrderDetails(id);
        productRepository.deleteById(id);
    }
}
