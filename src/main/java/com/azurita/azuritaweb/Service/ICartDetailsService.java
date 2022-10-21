package com.azurita.azuritaweb.Service;

import com.azurita.azuritaweb.DTO.CartDetailsDTO;
import com.azurita.azuritaweb.DTO.CartResponseDTO;
import com.azurita.azuritaweb.DTO.MessageDTO;
import com.azurita.azuritaweb.Entity.CartDetails;

import java.util.List;

public interface ICartDetailsService {
    CartDetailsDTO addItem(CartDetailsDTO cartDetailsDTO);

    public List<CartDetails> getAllCartDetails();

    MessageDTO deleteCartDetailsByProductIdAndSize(Long productId, String size);

    void deleteCartDetailsByCustomerId(Long customerId);

    List<CartDetailsDTO> saveListOfItems(List<CartDetailsDTO> cartDetailsDTO);

    List<CartResponseDTO> getDetailsByCustomerId(Long customerId);


}
