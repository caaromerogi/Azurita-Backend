package com.azurita.azuritaweb.Service;

import com.azurita.azuritaweb.DTO.OrderDetailsDTO;
import com.azurita.azuritaweb.Entity.OrderDetails;

import java.util.List;

public interface IOrderDetailsService {
    List<OrderDetailsDTO> saveOrderDetails(List<OrderDetailsDTO> orderDetailsDTO);
}
