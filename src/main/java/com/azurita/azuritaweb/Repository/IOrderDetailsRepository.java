package com.azurita.azuritaweb.Repository;

import com.azurita.azuritaweb.Entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
