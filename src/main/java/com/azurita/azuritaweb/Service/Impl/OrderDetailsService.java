package com.azurita.azuritaweb.Service.Impl;

import com.azurita.azuritaweb.DTO.OrderDetailsDTO;
import com.azurita.azuritaweb.Entity.OrderDetails;
import com.azurita.azuritaweb.Repository.IOrderDetailsRepository;
import com.azurita.azuritaweb.Service.IOrderDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderDetailsService implements IOrderDetailsService {

    @Autowired
    IOrderDetailsRepository orderDetailsRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Set<OrderDetails> saveOrderDetails(Set<OrderDetails> orderDetails) {
        return orderDetails.stream().map(orderItem -> orderDetailsRepository.save(orderItem)).collect(Collectors.toSet());
    }
}
