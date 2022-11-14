package com.azurita.azuritaweb.Service.Impl;

import com.azurita.azuritaweb.DTO.CartResponseDTO;
import com.azurita.azuritaweb.DTO.PurchaseOrderDTO;
import com.azurita.azuritaweb.Entity.OrderDetails;
import com.azurita.azuritaweb.Entity.Product;
import com.azurita.azuritaweb.Entity.PurchaseOrder;
import com.azurita.azuritaweb.Entity.SizeDetails;
import com.azurita.azuritaweb.Repository.IPurchaseOrderRepository;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PurchaseOrderServiceTest {

    PurchaseOrderService purchaseOrderService;

    @Mock
    IPurchaseOrderRepository purchaseOrderRepository;

    @Mock
    OrderDetailsService orderDetailsService;

    @Mock
    CartDetailsService cartDetailsService;

    ModelMapper modelMapper = new ModelMapper();

    @BeforeEach
    void init() {
        purchaseOrderService = new PurchaseOrderService(
                purchaseOrderRepository,
                orderDetailsService,
                cartDetailsService,
                modelMapper);
    }

    @Test
    void createOrder() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);

        PurchaseOrderDTO purchaseDTO = new PurchaseOrderDTO(
                1L,
                "15/11/2022",
                "Sahagún",
                "Calle 2 #33-12",
                1L
        );

        PurchaseOrder purchaseOrder = new PurchaseOrder(
                1L,
                "15/11/2022",
                null,
                "Sahagún",
                "Calle 2 #33-12",
                customer
        );

        CartResponseDTO cartResponseDTO = new CartResponseDTO();
        cartResponseDTO.setProductId(1L);
        cartResponseDTO.setQuantity(2);
        cartResponseDTO.setSize("XS");
        cartResponseDTO.setName("Blusa azul");
        cartResponseDTO.setPrice(10000.00);
        cartResponseDTO.setImgPath("img.com");

        Product product = new Product();
        SizeDetails size = new SizeDetails();
        size.setSize(SizeName.XS);
        product.setProductId(1L);
        product.setImgPath("img.com");
        product.setName("Blusa azul");
        product.setPrice(10000.00);
        product.setSizeDetails(Set.of(size));

        OrderDetails orderDetails = new OrderDetails(
                1L,
                "Blusa azul",
                "XS",
                20000.00,
                2,
                product,
                purchaseOrder
        );

        Set<OrderDetails> orderDetailsSet = new HashSet<>();
        orderDetailsSet.add(orderDetails);

        Mockito.when(purchaseOrderRepository.save(Mockito.any(PurchaseOrder.class))).thenReturn(purchaseOrder);
        Mockito.when(cartDetailsService.getDetailsByCustomerId(Mockito.any(Long.class))).thenReturn(List.of(cartResponseDTO));
        Mockito.when(orderDetailsService.saveOrderDetails(Mockito.anySet())).thenReturn(orderDetailsSet);

        PurchaseOrder purchaseOrderResult = purchaseOrderService.createOrder(purchaseDTO);

        Mockito.verify(cartDetailsService).deleteCartDetailsByCustomerId(Mockito.any(Long.class));
        Assertions.assertEquals(purchaseOrder, purchaseOrderResult);
    }

}