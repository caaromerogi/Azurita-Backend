package com.azurita.azuritaweb.Service.Impl;

import com.azurita.azuritaweb.Entity.SizeDetails;
import com.azurita.azuritaweb.Repository.ISizeDetailsRepository;
import com.azurita.azuritaweb.Security.enums.SizeName;
import com.azurita.azuritaweb.Service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;

public class SizeService implements ISizeService {
    @Autowired
    ISizeDetailsRepository sizeRepository;
    @Override
    public SizeDetails getBySizeName(SizeName sizeName) {
        return sizeRepository.findBySize(sizeName);
    }
}
