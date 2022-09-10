package com.azurita.azuritaweb.Controller;

import com.azurita.azuritaweb.DTO.ProductDTO;
import com.azurita.azuritaweb.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/get/findByProductId/{id}")
    public ResponseEntity<List<ProductDTO>> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/create/createProduct")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.ACCEPTED);
    }
}
