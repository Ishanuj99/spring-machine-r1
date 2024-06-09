package com.test.machine_coding.controller;

import com.test.machine_coding.DTO.PurchaseDTO;
import com.test.machine_coding.model.Deal;
import com.test.machine_coding.model.Purchase;
import com.test.machine_coding.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claim")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<Purchase> claimDeal(@RequestBody PurchaseDTO purchaseDTO ){
        try{
            Purchase purchase = purchaseService.claimDeal(purchaseDTO);
            return ResponseEntity.ok().body(purchase);
        }
        catch(RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
