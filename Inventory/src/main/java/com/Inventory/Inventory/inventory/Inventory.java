package com.Inventory.Inventory.inventory;

import com.Inventory.Inventory.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_inventory")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;

    private Integer availableQuantity;
    private Integer reservedQuantity = 0;

    private LocalDateTime lastUpdated = LocalDateTime.now();
}
