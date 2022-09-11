package com.azurita.azuritaweb.Service.Impl;

import com.azurita.azuritaweb.DTO.ProductDTO;
import com.azurita.azuritaweb.DTO.ResponseProductDTO;
import com.azurita.azuritaweb.DTO.SizeDetailsDTO;
import com.azurita.azuritaweb.Entity.Product;
import com.azurita.azuritaweb.Entity.SizeDetails;
import com.azurita.azuritaweb.Repository.ICartDetailsRepository;
import com.azurita.azuritaweb.Repository.IProductRepository;
import com.azurita.azuritaweb.Repository.ISizeDetailsRepository;
import com.azurita.azuritaweb.Security.enums.SizeName;
import com.azurita.azuritaweb.Service.IProductService;
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
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

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
        Set<SizeDetails> sizeDetails = new HashSet<>();
        if(sizes.contains("XS"))
            sizeDetails.add(sizeRepository.findBySize(SizeName.XS));
        if(sizes.contains("S"))
            sizeDetails.add(sizeRepository.findBySize(SizeName.S));
        if(sizes.contains("M"))
            sizeDetails.add(sizeRepository.findBySize(SizeName.M));
        if(sizes.contains("L"))
            sizeDetails.add(sizeRepository.findBySize(SizeName.L));
        if(sizes.contains("XL"))
            sizeDetails.add(sizeRepository.findBySize(SizeName.XL));
        if (sizes.contains("XXL"))
            sizeDetails.add(sizeRepository.findBySize(SizeName.XXL));

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
        return null;
    }
    @Transactional
    @Override
    public void deleteProductById(Long id) {
        //You should enter to the service NOT to the repository
        cartDetailsRepository.deleteByProductId(id);
        sizeRepository.deleteProductSizeById(id);
        productRepository.deleteById(id);
    }
}
