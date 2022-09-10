package com.azurita.azuritaweb.Repository;

import com.azurita.azuritaweb.Entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
