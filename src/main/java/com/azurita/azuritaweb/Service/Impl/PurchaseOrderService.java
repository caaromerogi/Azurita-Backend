package com.azurita.azuritaweb.Service.Impl;

import com.azurita.azuritaweb.DTO.CartDetailsDTO;
import com.azurita.azuritaweb.DTO.OrderDetailsDTO;
import com.azurita.azuritaweb.DTO.PurchaseOrderDTO;
import com.azurita.azuritaweb.Entity.CartDetails;
import com.azurita.azuritaweb.Entity.OrderDetails;
import com.azurita.azuritaweb.Entity.PurchaseOrder;
import com.azurita.azuritaweb.Repository.IPurchaseOrderRepository;
import com.azurita.azuritaweb.Service.ICartDetailsService;
import com.azurita.azuritaweb.Service.IOrderDetailsService;
import com.azurita.azuritaweb.Service.IPurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class PurchaseOrderService implements IPurchaseOrderService {
    @Autowired
    IPurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    IOrderDetailsService orderDetailsService;

    @Autowired
    ICartDetailsService cartDetailsService; //traer la info al orderdetails y luego borrarla

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @Override
    public PurchaseOrder createOrder(PurchaseOrderDTO purchaseOrder) {
        PurchaseOrder order = modelMapper.map(purchaseOrder, PurchaseOrder.class);
        PurchaseOrder resultOrder = purchaseOrderRepository.save(order);

        Set<OrderDetailsDTO> orderDetailsDTO = cartDetailsService.getDetailsByCustomerId(purchaseOrder.getCustomerId())
                .stream().map(cartItem -> {
                    OrderDetailsDTO orderDTO = new OrderDetailsDTO();
                    orderDTO.setPurchaseOrderId(resultOrder.getPurchaseOrderId());
                    orderDTO.setProductName(cartItem.getProduct().getName());
                    orderDTO.setProductId(cartItem.getProduct().getProductId());
                    orderDTO.setQuantity(cartItem.getQuantity());
                    orderDTO.setSize(cartItem.getSize());
                    orderDTO.setTotal(cartItem.getQuantity()*cartItem.getProduct().getPrice());
                    return orderDTO;
                }).collect(Collectors.toSet());

        Set<OrderDetails> orderDetails = orderDetailsDTO.stream().map(orderDTO-> modelMapper.map(orderDTO,OrderDetails.class))
                .collect(Collectors.toSet());

        //FALTA SETEAR EL TOTAL

        orderDetailsService.saveOrderDetails(orderDetails);

        cartDetailsService.deleteCartDetailsByCustomerId(purchaseOrder.getCustomerId());

        //crear un purchase order response que tenga los datos necesarios

        return resultOrder;
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }


}
