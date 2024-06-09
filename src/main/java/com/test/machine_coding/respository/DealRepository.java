package com.test.machine_coding.respository;

import com.test.machine_coding.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<Deal, String> {
}
