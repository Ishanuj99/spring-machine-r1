package com.test.machine_coding.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "inventory")
@Entity
public class ProductInventory {
    @Id
    String id;
    double price;
    int stock;
}
