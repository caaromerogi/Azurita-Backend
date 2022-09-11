package com.azurita.azuritaweb.Service;

import com.azurita.azuritaweb.DTO.CartDetailsDTO;
import com.azurita.azuritaweb.Entity.CartDetails;

import java.util.List;

public interface ICartDetailsService {
    CartDetailsDTO addItem(CartDetailsDTO cartDetailsDTO);

    public List<CartDetails> getAllCartDetails();

    void deleteCartDetailsByProductId(Long productId);

    void deleteCartDetailsByCustomerId(Long customerId);

    List<CartDetailsDTO> saveListOfItems(List<CartDetailsDTO> cartDetailsDTO);

    List<CartDetails> getDetailsByCustomerId(Long customerId);


}
