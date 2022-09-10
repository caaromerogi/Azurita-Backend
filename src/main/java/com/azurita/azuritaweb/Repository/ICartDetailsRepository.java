package com.azurita.azuritaweb.Repository;

import com.azurita.azuritaweb.Entity.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartDetailsRepository extends JpaRepository<CartDetails, Long> {
}
