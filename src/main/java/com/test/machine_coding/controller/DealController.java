package com.test.machine_coding.controller;

import com.test.machine_coding.DTO.DealDTO;
import com.test.machine_coding.DTO.UpdateDealDTO;
import com.test.machine_coding.model.Deal;
import com.test.machine_coding.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deals")
public class DealController {
    @Autowired
    DealService dealService;

    @PostMapping("/create")
    public ResponseEntity<Deal> creteDeal(@RequestBody DealDTO dealDTO){
        try{
            Deal deal = dealService.createDeal(dealDTO);
            return ResponseEntity.ok().body(deal);
        }
        catch(RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/endDeal/{id}")
    public ResponseEntity<?> endDeal(@PathVariable String id){
        try{
            dealService.endDeal(id);
            return ResponseEntity.ok().body("Deal has been ended succesfully");
        }
        catch(RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/updateDeal/{id}")
    public ResponseEntity<Deal> updateDeal(@PathVariable String id, @RequestBody UpdateDealDTO updateDealDTO){
        try{
            Deal deal = dealService.updateDeal(id, updateDealDTO);
            return ResponseEntity.ok().body(deal);
        }
        catch(RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
