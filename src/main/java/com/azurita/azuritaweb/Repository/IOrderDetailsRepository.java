package com.azurita.azuritaweb.Repository;

import com.azurita.azuritaweb.Entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IOrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
