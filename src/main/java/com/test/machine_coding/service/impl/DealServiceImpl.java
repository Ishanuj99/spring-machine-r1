package com.test.machine_coding.service.impl;

import com.test.machine_coding.DTO.DealDTO;
import com.test.machine_coding.DTO.UpdateDealDTO;
import com.test.machine_coding.DTO.UpdateStockDTO;
import com.test.machine_coding.model.Deal;
import com.test.machine_coding.model.ProductInventory;
import com.test.machine_coding.respository.DealRepository;
import com.test.machine_coding.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DealServiceImpl implements DealService {
    @Autowired
    DealRepository dealRepository;

    @Override
    public Deal createDeal(DealDTO dealDTO){
        Deal deal = Deal.builder()
                .dealId(String.valueOf(UUID.randomUUID()))
                .startTime(dealDTO.getStartTime())
                .isActive(true)
                .endTime(dealDTO.getEndTime())
                .inventory(dealDTO.getInventory())
                .build();
        return dealRepository.save(deal);
    }

    @Override
    public void endDeal(String id){
        Deal deal = dealRepository.findById(id).orElse(null);
        if(deal == null){
            throw new RuntimeException("Deal with id"+id+ " does not exist");
        }
        else {
            deal.setActive(false);
            dealRepository.save(deal);
        }
    }

    @Override
    public Deal updateDeal(String id, UpdateDealDTO updateDealDTO){
        Deal deal = dealRepository.findById(id).orElse(null);
        if(deal == null){
            throw new RuntimeException("Deal with id"+id+" does not exist");
        }
        else {
            LocalDateTime endTime = updateDealDTO.getEndTime();
            UpdateStockDTO updateStock = updateDealDTO.getUpdateStockDTO();
            List<ProductInventory> dealInventory = deal.getInventory();
            String updateStockId = updateStock.getId();
            for (ProductInventory productInventory : dealInventory) {
                if(productInventory.getId().equals(updateStockId)){
                    productInventory.setStock(updateStock.getStock());
                }
            }
            deal.setEndTime(endTime);
        }
        return dealRepository.save(deal);
    }
}
