package com.test.machine_coding.service.impl;

import com.test.machine_coding.DTO.PurchaseDTO;
import com.test.machine_coding.model.Deal;
import com.test.machine_coding.model.Purchase;
import com.test.machine_coding.respository.DealRepository;
import com.test.machine_coding.respository.PurchaseRepository;
import com.test.machine_coding.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    DealRepository dealRepository;
    public Purchase claimDeal(PurchaseDTO purchaseDTO){
        List<Purchase> purchaseExistsByUser = purchaseRepository.findAllByUserId(purchaseDTO.getUserId());

        if(purchaseExistsByUser != null && purchaseExistsByUser.size()>0){
            throw new RuntimeException("Purchase already found with the given ID");
        }
        Deal deal = dealRepository.findById(purchaseDTO.getDealId()).orElse(null);
        assert deal != null;
        if(deal.getEndTime().isBefore(LocalDateTime.now()) || !deal.isActive()){
            throw new RuntimeException("Deal has already expired");
        }
        Purchase purchase = Purchase.builder()
                .purchaseId(String.valueOf(UUID.randomUUID()))
                .dealId(purchaseDTO.getDealId())
                .userId(purchaseDTO.getUserId())
                .purchaseTimestamp(LocalDateTime.now())
                            .build();
        return purchaseRepository.save(purchase);
    }
}
