package com.test.machine_coding.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "deal")
@Getter
@Setter
@Builder
public class Deal {
    @Id
    String dealId;
    LocalDateTime startTime;
    LocalDateTime endTime;
    boolean isActive;
    @OneToMany
    List<ProductInventory> inventory;
}
