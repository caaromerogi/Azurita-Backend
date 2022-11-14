package com.azurita.azuritaweb.Service.Impl;

import com.azurita.azuritaweb.DTO.CartDetailsDTO;
import com.azurita.azuritaweb.DTO.CartResponseDTO;
import com.azurita.azuritaweb.DTO.MessageDTO;
import com.azurita.azuritaweb.DTO.ResponseProductDTO;
import com.azurita.azuritaweb.Entity.CartDetails;
import com.azurita.azuritaweb.Repository.ICartDetailsRepository;
import com.azurita.azuritaweb.Service.ICartDetailsService;
import com.azurita.azuritaweb.Service.IProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartDetailsService implements ICartDetailsService {
    @Autowired
    ICartDetailsRepository cartDetailsRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @Override
    public CartDetailsDTO addItem(CartDetailsDTO cartDetailsDTO) {
        if(cartDetailsRepository.findByCustomerAndProductId(cartDetailsDTO.getCustomerId(),
                cartDetailsDTO.getProductId(), cartDetailsDTO.getSize()).isPresent()

        && Objects.equals(cartDetailsRepository.findByCustomerAndProductId(cartDetailsDTO.getCustomerId(),
                cartDetailsDTO.getProductId(),cartDetailsDTO.getSize()).get().getSize(), cartDetailsDTO.getSize()))
        {
            CartDetails cart = cartDetailsRepository.findByCustomerAndProductId(cartDetailsDTO.getCustomerId(),
                    cartDetailsDTO.getProductId(),cartDetailsDTO.getSize()).get();
            cart.setQuantity(cart.getQuantity() + cartDetailsDTO.getQuantity());
            return modelMapper.map(cartDetailsRepository.save(cart), CartDetailsDTO.class);
        }

        CartDetails cart = modelMapper.map(cartDetailsDTO, CartDetails.class);
        return modelMapper.map(cartDetailsRepository.save(cart), CartDetailsDTO.class);
    }


    public List<CartDetails> getAllCartDetails(){
        return cartDetailsRepository.findAll();
    }

    @Override
    public MessageDTO deleteCartDetailsByProductIdAndSize(Long productId, String size) {
        cartDetailsRepository.deleteByProductIdAndSize(productId, size);
        return new MessageDTO("Item "+productId +" deleted");
    }

    @Override
    public void deleteCartDetailsByCustomerId(Long customerId) {
        cartDetailsRepository.deleteByCustomerId(customerId);
    }

    @Transactional
    @Override
    public List<CartDetailsDTO> saveListOfItems(List<CartDetailsDTO> cartDetailsDTO) {
        deleteCartDetailsByCustomerId(cartDetailsDTO.get(0).getCustomerId());
        return cartDetailsDTO.stream().map(cartDetails -> {
            CartDetails modifiedCartItem = modelMapper.map(cartDetails, CartDetails.class);
            return modelMapper.map(cartDetailsRepository.save(modifiedCartItem), CartDetailsDTO.class);
        }).collect(Collectors.toList());
    }

    @Override
    public List<CartResponseDTO> getDetailsByCustomerId(Long customerId) {
        return cartDetailsRepository.findByCustomerId(customerId)
                .stream()
                .map(item -> {
                    CartResponseDTO cartResponse = new CartResponseDTO();
                    cartResponse.setProductId(item.getProduct().getProductId());
                    cartResponse.setName(item.getProduct().getName());
                    cartResponse.setPrice(item.getProduct().getPrice());
                    cartResponse.setImgPath(item.getProduct().getImgPath());
                    cartResponse.setSize(item.getSize());
                    cartResponse.setQuantity(item.getQuantity());
                    return cartResponse;
                }).collect(Collectors.toList());
    }


}
