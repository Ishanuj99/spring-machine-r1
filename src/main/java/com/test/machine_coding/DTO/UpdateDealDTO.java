package com.test.machine_coding.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateDealDTO {
    LocalDateTime endTime;
    UpdateStockDTO updateStockDTO;
}
