package com.azurita.azuritaweb.Controller;

import com.azurita.azuritaweb.DTO.CartDetailsDTO;
import com.azurita.azuritaweb.Entity.CartDetails;
import com.azurita.azuritaweb.Service.ICartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartDetailsController {
    @Autowired
    ICartDetailsService cartDetailsService;

    @PostMapping("/cud/addItemToCart")
    public ResponseEntity<CartDetailsDTO> addItemToCart(@RequestBody CartDetailsDTO cartDetailsDTO){
        return new ResponseEntity<>(cartDetailsService.addItem(cartDetailsDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get/getAllCartDetails")
    public ResponseEntity<List<CartDetails>> getAllCartDetails(){
        return new ResponseEntity<>(cartDetailsService.getAllCartDetails(), HttpStatus.OK);
    }
}
