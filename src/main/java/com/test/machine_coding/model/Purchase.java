package com.test.machine_coding.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    String purchaseId;
    LocalDateTime purchaseTimestamp;
    String dealId;
    String userId;
}
