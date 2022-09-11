package com.azurita.azuritaweb.Service.Impl;

import com.azurita.azuritaweb.DTO.OrderDetailsDTO;
import com.azurita.azuritaweb.Entity.OrderDetails;
import com.azurita.azuritaweb.Repository.IOrderDetailsRepository;
import com.azurita.azuritaweb.Service.IOrderDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderDetailsService implements IOrderDetailsService {

    @Autowired
    IOrderDetailsRepository orderDetailsRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<OrderDetailsDTO> saveOrderDetails(List<OrderDetailsDTO> orderDetailsDTO) {
        return null;
    }

//    @Transactional
//    @Override
//    public List<OrderDetailsDTO> saveOrderDetails(List<OrderDetailsDTO> orderDetailsDTO, id) {
//        return orderDetailsDTO.stream().map(order -> );
//    }
}
