package com.azurita.azuritaweb.Service;

import com.azurita.azuritaweb.DTO.PurchaseOrderDTO;
import com.azurita.azuritaweb.Entity.PurchaseOrder;

import java.util.List;

public interface IPurchaseOrderService {
    PurchaseOrder createOrder(PurchaseOrderDTO purchaseOrder);

    List<PurchaseOrder> getAllPurchaseOrders();
}
