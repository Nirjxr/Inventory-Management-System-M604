package com.Inventory.Inventory.stockTransaction;

import com.Inventory.Inventory.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_stock_transactions")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;
    private Integer quantity;
    private String transactionType;
    private String reason;
    private LocalDateTime transactionDate = LocalDateTime.now();
    private String performedBy;
}
