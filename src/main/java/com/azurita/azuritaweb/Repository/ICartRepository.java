package com.azurita.azuritaweb.Repository;

import com.azurita.azuritaweb.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart,Long> {
}
