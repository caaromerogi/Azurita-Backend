package com.azurita.azuritaweb.Service.Impl;

import com.azurita.azuritaweb.DTO.CartDetailsDTO;
import com.azurita.azuritaweb.DTO.ResponseProductDTO;
import com.azurita.azuritaweb.Entity.CartDetails;
import com.azurita.azuritaweb.Repository.ICartDetailsRepository;
import com.azurita.azuritaweb.Service.ICartDetailsService;
import com.azurita.azuritaweb.Service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartDetailsService implements ICartDetailsService {
    @Autowired
    ICartDetailsRepository cartDetailsRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @Override
    public CartDetailsDTO addItem(CartDetailsDTO cartDetailsDTO) {
        if(cartDetailsRepository.findByCustomerAndProductId(cartDetailsDTO.getCustomerId(),
                cartDetailsDTO.getProductId()).isPresent()) {
            CartDetails cart = cartDetailsRepository.findByCustomerAndProductId(cartDetailsDTO.getCustomerId(),
                    cartDetailsDTO.getProductId()).get();
            cart.setQuantity(cart.getQuantity() + 1);
            return modelMapper.map(cartDetailsRepository.save(cart), CartDetailsDTO.class);
        }

        cartDetailsDTO.setQuantity(1);
        CartDetails cart = modelMapper.map(cartDetailsDTO, CartDetails.class);
        return modelMapper.map(cartDetailsRepository.save(cart), CartDetailsDTO.class);
    }


    public List<CartDetails> getAllCartDetails(){
        return cartDetailsRepository.findAll();
    }

    @Override
    public void deleteCartDetailsByProductId(Long productId) {
        cartDetailsRepository.deleteByProductId(productId);
    }

    @Override
    public void deleteCartDetailsByCustomerId(Long customerId) {
        cartDetailsRepository.deleteByCustomerId(customerId);
    }

    @Transactional
    @Override
    public List<CartDetailsDTO> saveListOfItems(List<CartDetailsDTO> cartDetailsDTO) {
        return cartDetailsDTO.stream().map(cartDetails -> {
            CartDetails modifiedCartItem = modelMapper.map(cartDetails, CartDetails.class);
            return modelMapper.map(cartDetailsRepository.save(modifiedCartItem), CartDetailsDTO.class);
        }).collect(Collectors.toList());
    }

    @Override
    public List<CartDetails> getDetailsByCustomerId(Long customerId) {
        return cartDetailsRepository.findByCustomerId(customerId);
    }


}
