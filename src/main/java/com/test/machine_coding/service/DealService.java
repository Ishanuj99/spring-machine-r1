package com.test.machine_coding.service;

import com.test.machine_coding.DTO.DealDTO;
import com.test.machine_coding.DTO.UpdateDealDTO;
import com.test.machine_coding.model.Deal;

public interface DealService {
    Deal createDeal(DealDTO dealDTO);
    void endDeal(String id);
    Deal updateDeal(String id, UpdateDealDTO updateDealDTO);
}
