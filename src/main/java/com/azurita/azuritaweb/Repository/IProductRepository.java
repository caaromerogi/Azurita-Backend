package com.azurita.azuritaweb.Repository;

import com.azurita.azuritaweb.DTO.ProductDTO;
import com.azurita.azuritaweb.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

}
