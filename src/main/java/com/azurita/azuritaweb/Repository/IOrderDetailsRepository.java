package com.azurita.azuritaweb.Repository;

import com.azurita.azuritaweb.Entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Set;

@Repository
public interface IOrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    @Query(value = "SELECT * FROM order_details WHERE order_id =:orderId",
            nativeQuery = true)
    List<OrderDetails> findByOrderId(@Param("orderId") Long orderId);

    @Query(value = "SELECT * FROM order_details WHERE product_id =:productId",
            nativeQuery = true)
    Set<OrderDetails> findByProductId(@Param("productId") Long productId);
}
