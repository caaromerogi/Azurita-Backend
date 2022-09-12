package com.azurita.azuritaweb.DTO;

import com.azurita.azuritaweb.Entity.OrderDetails;
import com.azurita.azuritaweb.Security.Entity.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseOrderDTO {
    private Long id;

    private String date;

    private String municipality;

    private String address;

    private Long customerId;


}
