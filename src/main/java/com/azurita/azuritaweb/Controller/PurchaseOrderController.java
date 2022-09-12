package com.azurita.azuritaweb.Controller;

import com.azurita.azuritaweb.DTO.PurchaseOrderDTO;
import com.azurita.azuritaweb.Entity.PurchaseOrder;
import com.azurita.azuritaweb.Service.IPurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseOrderController {
    @Autowired
    IPurchaseOrderService purchaseOrderService;

    @PostMapping("/user/generatePurchaseOrder")
    public ResponseEntity<PurchaseOrder> generatePurchaseOrder(@RequestBody PurchaseOrderDTO purchaseOrderDTO){
        return new ResponseEntity<>(purchaseOrderService.createOrder(purchaseOrderDTO), HttpStatus.OK);
    }

    @GetMapping("/cud/getAllPurchaseOrders")
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders(){
        return new ResponseEntity<>(purchaseOrderService.getAllPurchaseOrders(), HttpStatus.OK);
    }
}
