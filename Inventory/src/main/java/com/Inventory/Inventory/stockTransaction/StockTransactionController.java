package com.Inventory.Inventory.stockTransaction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stock-transactions")
public class StockTransactionController {

    private final StockTransactionService service;

    public StockTransactionController(StockTransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<StockTransaction> getAll() {
        return service.getAll();
    }

    @GetMapping("/product/{productId}")
    public List<StockTransaction> getByProduct(@PathVariable Long productId) {
        return service.getByProduct(productId);
    }
}
