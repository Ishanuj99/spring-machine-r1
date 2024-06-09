package com.test.machine_coding.DTO;

import com.test.machine_coding.model.ProductInventory;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DealDTO {
    LocalDateTime startTime;
    LocalDateTime endTime;
    List<ProductInventory> inventory;
}