package com.azurita.azuritaweb.Controller;

import com.azurita.azuritaweb.DTO.MessageDTO;
import com.azurita.azuritaweb.DTO.ProductDTO;
import com.azurita.azuritaweb.DTO.ResponseProductDTO;
import com.azurita.azuritaweb.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/get/findByProductId/{id}")
    public ResponseEntity<ResponseProductDTO> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping("/cud/create/createProduct")
    public ResponseEntity<ResponseProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/getAllProducts")
    public ResponseEntity<List<ResponseProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @DeleteMapping("/cud/deleteProduct/{id}")
    public ResponseEntity<MessageDTO> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return new ResponseEntity<>(new MessageDTO("Producto eliminado satisfactoriamente"), HttpStatus.OK);
    }
}
