package com.azurita.azuritaweb.Controller;

import com.azurita.azuritaweb.DTO.PurchaseOrderDTO;
import com.azurita.azuritaweb.Entity.OrderDetails;
import com.azurita.azuritaweb.Entity.PurchaseOrder;
import com.azurita.azuritaweb.Service.IPurchaseOrderService;
import com.azurita.azuritaweb.Service.Impl.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PurchaseOrderController {
    @Autowired
    IPurchaseOrderService purchaseOrderService;

    @Autowired
    PurchaseOrderService purchaseOrderServices;

    @PostMapping("/user/generatePurchaseOrder")
    public ResponseEntity<PurchaseOrder> generatePurchaseOrder(@RequestBody PurchaseOrderDTO purchaseOrderDTO){
        return new ResponseEntity<>(purchaseOrderService.createOrder(purchaseOrderDTO), HttpStatus.OK);
    }

    @GetMapping("/cud/getAllPurchaseOrders")
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders(){
        return new ResponseEntity<>(purchaseOrderService.getAllPurchaseOrders(), HttpStatus.OK);
    }

    //Borrar
    @GetMapping("/user/getOrder/{orderId}")
    public ResponseEntity<List<OrderDetails>> getOrderDetails(@PathVariable Long orderId){
        return new ResponseEntity<>(purchaseOrderServices.getOrderDetails(orderId), HttpStatus.OK);
    }
}
