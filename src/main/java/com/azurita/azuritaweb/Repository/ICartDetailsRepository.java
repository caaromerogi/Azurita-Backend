package com.azurita.azuritaweb.Repository;

import com.azurita.azuritaweb.DTO.ResponseProductDTO;
import com.azurita.azuritaweb.Entity.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICartDetailsRepository extends JpaRepository<CartDetails, Long> {
    @Query(value = "SELECT * FROM cart_details WHERE customer_id =:customerId AND product_id=:productId",
            nativeQuery = true)
    Optional<CartDetails> findByCustomerAndProductId(@Param("customerId") Long customerId, @Param("productId") Long productId);

    @Query(value = "SELECT * FROM product WHERE product_id=:productId", nativeQuery = true)
    Optional<ResponseProductDTO> findByProductId(@Param("productId") Long productId);

    @Modifying
    @Query(value = "DELETE FROM cart_details WHERE product_id =:id",
            nativeQuery = true)
    void deleteByProductId(@Param("id") Long productId);

}
