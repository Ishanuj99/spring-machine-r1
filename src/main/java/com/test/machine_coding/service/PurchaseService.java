package com.test.machine_coding.service;


import com.test.machine_coding.DTO.PurchaseDTO;
import com.test.machine_coding.model.Purchase;

public interface PurchaseService {
    Purchase claimDeal(PurchaseDTO purchaseDTO);
}
