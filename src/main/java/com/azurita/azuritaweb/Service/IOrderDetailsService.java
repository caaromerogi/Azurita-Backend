package com.azurita.azuritaweb.Service;

import com.azurita.azuritaweb.DTO.OrderDetailsDTO;
import com.azurita.azuritaweb.Entity.OrderDetails;

import java.util.List;
import java.util.Set;

public interface IOrderDetailsService {
    Set<OrderDetails> saveOrderDetails(Set<OrderDetails> orderDetails);

    Set<OrderDetails> updateOrderDetails(Long productId);
    OrderDetails saveOrderDetail(OrderDetails order);
    List<OrderDetails> getOrderDetails(Long orderId);
}
