package com.azurita.azuritaweb.Service;

import com.azurita.azuritaweb.Entity.SizeDetails;
import com.azurita.azuritaweb.Security.enums.SizeName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISizeService {
    SizeDetails getBySizeName(SizeName sizeName);


}
