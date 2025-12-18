package com.Inventory.Inventory.product;

import com.Inventory.Inventory.category.Category;
import com.Inventory.Inventory.supplier.Supplier;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private String status;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Supplier supplier;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
}

