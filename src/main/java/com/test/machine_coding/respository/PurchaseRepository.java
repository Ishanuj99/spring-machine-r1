package com.test.machine_coding.respository;

import com.test.machine_coding.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {
    List<Purchase> findAllByUserId(String id);
}
