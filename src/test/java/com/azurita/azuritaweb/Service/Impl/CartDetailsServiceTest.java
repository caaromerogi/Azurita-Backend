package com.azurita.azuritaweb.Service.Impl;

import com.azurita.azuritaweb.DTO.CartDetailsDTO;
import com.azurita.azuritaweb.DTO.CartResponseDTO;
import com.azurita.azuritaweb.Entity.CartDetails;
import com.azurita.azuritaweb.Entity.Product;
import com.azurita.azuritaweb.Entity.SizeDetails;
import com.azurita.azuritaweb.Repository.ICartDetailsRepository;
import com.azurita.azuritaweb.Security.Entity.Customer;
import com.azurita.azuritaweb.Security.enums.SizeName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CartDetailsServiceTest {

    CartDetailsService cartDetailsService;

    @Mock
    ICartDetailsRepository cartDetailsRepository;

    ModelMapper modelMapper = new ModelMapper();

    @BeforeEach
    void init(){
        cartDetailsService = new CartDetailsService(cartDetailsRepository, modelMapper);
    }

    @Test
    void addItem() {
        Product product = new Product();
        SizeDetails size = new SizeDetails();
        size.setSize(SizeName.XS);
        product.setProductId(1L);
        product.setImgPath("img.com");
        product.setName("Blusa roja");
        product.setPrice(5000.00);
        product.setSizeDetails(Set.of(size));

        Customer customer = new Customer(
                "Carlos",
                "Romero",
                "caaromerogi@unal.edu.co",
                "1037671545",
                "12345678"
        );

        CartDetails cartDetails = new CartDetails(
                1L,
                "XS",
                product,
                customer,
                2
        );

        CartDetails emptyCartDetails = new CartDetails();

        CartDetailsDTO cartDetailsDTOExpected = new CartDetailsDTO(
                1L,
                1L,
                "XS",
                1L,
                2
        );


        Mockito.when(cartDetailsRepository.findByCustomerAndProductId(
                Mockito.any(Long.class),
                Mockito.any(Long.class),
                Mockito.any(String.class))).thenReturn(Optional.of(emptyCartDetails));

        Mockito.when(cartDetailsRepository.save(Mockito.any(CartDetails.class))).thenReturn(cartDetails);

        CartDetailsDTO cartDetailsDTO = cartDetailsService.addItem(cartDetailsDTOExpected);

        Assertions.assertEquals(cartDetailsDTOExpected.getSize(), cartDetailsDTO.getSize());
        Assertions.assertEquals(cartDetailsDTOExpected.getProductId(), cartDetailsDTO.getProductId());
        Assertions.assertEquals(cartDetailsDTOExpected.getQuantity(), cartDetailsDTO.getQuantity());
    }

    @Test
    void deleteCartDetailsByProductIdAndSize() {
        cartDetailsService.deleteCartDetailsByProductIdAndSize(1L, "XS");
        Mockito.verify(cartDetailsRepository).deleteByProductIdAndSize(1L,"XS");


    }

    @Test
    void getDetailsByCustomerId() {
        Product product = new Product();
        SizeDetails size = new SizeDetails();
        size.setSize(SizeName.XS);
        product.setProductId(1L);
        product.setImgPath("img.com");
        product.setName("Blusa roja");
        product.setPrice(5000.00);
        product.setSizeDetails(Set.of(size));

        Customer customer = new Customer(
                "Carlos",
                "Romero",
                "caaromerogi@unal.edu.co",
                "1037671545",
                "12345678"
        );
        customer.setCustomerId(1L);

        CartDetails cartDetailsExpected = new CartDetails(
                1L,
                "XS",
                product,
                customer,
                2
        );

        CartDetails cartDetailsExpected2 = new CartDetails(
                1L,
                "S",
                product,
                customer,
                2
        );



        Mockito.when(cartDetailsRepository.findByCustomerId(Mockito.any(Long.class)))
                .thenReturn(List.of(cartDetailsExpected,cartDetailsExpected2));

        List<CartResponseDTO> cartDetailsDTOSResult = cartDetailsService.getDetailsByCustomerId(1L);

        Assertions.assertEquals(2, cartDetailsDTOSResult.size());
    }
}