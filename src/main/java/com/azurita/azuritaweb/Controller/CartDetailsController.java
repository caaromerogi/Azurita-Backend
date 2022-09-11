package com.azurita.azuritaweb.Controller;

import com.azurita.azuritaweb.DTO.CartDetailsDTO;
import com.azurita.azuritaweb.Entity.CartDetails;
import com.azurita.azuritaweb.Service.ICartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartDetailsController {
    @Autowired
    ICartDetailsService cartDetailsService;

    @PostMapping("/cud/addItemToCart")
    public ResponseEntity<CartDetailsDTO> addItemToCart(@RequestBody CartDetailsDTO cartDetailsDTO){
        return new ResponseEntity<>(cartDetailsService.addItem(cartDetailsDTO), HttpStatus.CREATED);
    }

    //TESTEANDO PERO NO DEBEN SER IMPLEMENTADOS INTERNAMENTE
    @GetMapping("/get/getAllCartDetails")
    public ResponseEntity<List<CartDetails>> getAllCartDetails(){
        return new ResponseEntity<>(cartDetailsService.getAllCartDetails(), HttpStatus.OK);
    }

    @GetMapping("/get/getCartDetails/{id}")
    public ResponseEntity<List<CartDetails>> getCartDetailsByCustomerId(@PathVariable Long id){
        return new ResponseEntity<>(cartDetailsService.getDetailsByCustomerId(id), HttpStatus.OK);
    }

}
