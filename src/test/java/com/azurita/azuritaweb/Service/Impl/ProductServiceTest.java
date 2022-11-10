package com.azurita.azuritaweb.Service.Impl;

import com.azurita.azuritaweb.DTO.ProductDTO;
import com.azurita.azuritaweb.DTO.ResponseProductDTO;
import com.azurita.azuritaweb.Entity.Product;
import com.azurita.azuritaweb.Entity.SizeDetails;
import com.azurita.azuritaweb.Repository.ICartDetailsRepository;
import com.azurita.azuritaweb.Repository.IProductRepository;
import com.azurita.azuritaweb.Repository.ISizeDetailsRepository;
import com.azurita.azuritaweb.Security.enums.SizeName;
import com.azurita.azuritaweb.Service.IOrderDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    ProductService productService;

    @Mock
    IProductRepository productRepository;

    @Mock
    IOrderDetailsService orderDetailsService;

    @Mock
    ISizeDetailsRepository sizeDetailsRepository;

    @Mock
    ICartDetailsRepository cartDetailsRepository;

    ModelMapper modelMapper = new ModelMapper();

    @BeforeEach
    void init(){
        productService = new ProductService(
                productRepository,
                orderDetailsService,
                sizeDetailsRepository,
                cartDetailsRepository,
                modelMapper);
    }

    @Test
    void createProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(1L);
        productDTO.setImgPath("img.com");
        productDTO.setName("Blusa roja");
        productDTO.setSizes(Set.of("XS"));
        productDTO.setPrice(5000.00);

        Product product = new Product();
        SizeDetails size = new SizeDetails();
        size.setSize(SizeName.XS);
        product.setProductId(1L);
        product.setImgPath("img.com");
        product.setName("Blusa roja");
        product.setPrice(5000.00);
        product.setSizeDetails(Set.of(size));

        Mockito.when(sizeDetailsRepository.findBySize(Mockito.any(SizeName.class))).thenReturn(Optional.of(size));
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        ResponseProductDTO productResponse = productService.createProduct(productDTO);

        Assertions.assertEquals(productDTO.getPrice(), productResponse.getPrice());
        Assertions.assertEquals(productDTO.getName(), productResponse.getName());
        Assertions.assertEquals(productDTO.getImgPath(), productResponse.getImgPath());
        Assertions.assertEquals(productDTO.getProductId(), productResponse.getProductId());
        Assertions.assertEquals(productDTO.getSizes().size(), productResponse.getSizeDetails().size());
    }

    @Test
    void getProductById() {
        Product product = new Product();
        SizeDetails size = new SizeDetails();
        size.setSize(SizeName.XS);
        product.setProductId(1L);
        product.setImgPath("img.com");
        product.setName("Blusa roja");
        product.setPrice(5000.00);
        product.setSizeDetails(Set.of(size));

        Mockito.when(productRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(product));

        ResponseProductDTO productResponse = productService.getProductById(1L);

        Assertions.assertEquals(product.getPrice(), productResponse.getPrice());
        Assertions.assertEquals(product.getName(), productResponse.getName());
        Assertions.assertEquals(product.getImgPath(), productResponse.getImgPath());
        Assertions.assertEquals(product.getProductId(), productResponse.getProductId());
        Assertions.assertEquals(product.getSizeDetails().size(), productResponse.getSizeDetails().size());
    }

    @Test
    void getAllProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        Product product2 = new Product();

        products.add(product1);
        products.add(product2);

        Mockito.when(productRepository.findAll()).thenReturn(products);

        List<ResponseProductDTO> productDTOS = productService.getAllProducts();

        Assertions.assertEquals(products.size(),productDTOS.size());


    }

    @Test
    void deleteProductById() {
        productService.deleteProductById(1L);
        Mockito.verify(productRepository).deleteById(1L);
        Mockito.verify(cartDetailsRepository).deleteByProductId(1L);
        Mockito.verify(sizeDetailsRepository).deleteProductSizeById(1L);
        Mockito.verify(orderDetailsService).updateOrderDetails(1L);
    }
}