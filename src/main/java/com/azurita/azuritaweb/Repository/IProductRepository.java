package com.azurita.azuritaweb.Repository;

import com.azurita.azuritaweb.DTO.ProductDTO;
import com.azurita.azuritaweb.Entity.Product;
import com.azurita.azuritaweb.ID.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, ProductId> {
    @Query(value = "SELECT * FROM product WHERE product_id =:product_id", nativeQuery = true)
    List<Product> findByProductId(@Param("product_id")Long productId);
}
