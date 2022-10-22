package com.azurita.azuritaweb.Controller;

import com.azurita.azuritaweb.DTO.CartDetailsDTO;
import com.azurita.azuritaweb.DTO.CartResponseDTO;
import com.azurita.azuritaweb.DTO.MessageDTO;
import com.azurita.azuritaweb.Entity.CartDetails;
import com.azurita.azuritaweb.Service.ICartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CartDetailsController {
    @Autowired
    ICartDetailsService cartDetailsService;

    @PostMapping("/user/addItemToCart")
    public ResponseEntity<CartDetailsDTO> addItemToCart(@RequestBody CartDetailsDTO cartDetailsDTO){
        return new ResponseEntity<>(cartDetailsService.addItem(cartDetailsDTO), HttpStatus.CREATED);
    }

    //TESTEANDO PERO NO DEBEN SER IMPLEMENTADOS INTERNAMENTE
    @GetMapping("/user/getAllCartDetails")
    public ResponseEntity<List<CartDetails>> getAllCartDetails(){
        return new ResponseEntity<>(cartDetailsService.getAllCartDetails(), HttpStatus.OK);
    }

    @GetMapping("/user/getCartDetailsByCustomer/{id}")
    public ResponseEntity<List<CartResponseDTO>> getCartDetailsByCustomerId(@PathVariable Long id){
        return new ResponseEntity<>(cartDetailsService.getDetailsByCustomerId(id), HttpStatus.OK);
    }

    @DeleteMapping("/user/deleteCartItem/{id}/{size}")
    public ResponseEntity<MessageDTO> deleteCartItem(@PathVariable("id") Long id, @PathVariable("size") String size){
        return new ResponseEntity<>(cartDetailsService.deleteCartDetailsByProductIdAndSize(id,size), HttpStatus.OK);
    }

    @PostMapping("/user/saveItems")
    public ResponseEntity<List<CartDetailsDTO>> saveCartItems(@RequestBody List<CartDetailsDTO> cartItems){
        return new ResponseEntity<>(cartDetailsService.saveListOfItems(cartItems), HttpStatus.OK);
    }

}
