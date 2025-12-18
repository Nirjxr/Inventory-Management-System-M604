package com.Inventory.Inventory.stockTransaction;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockTransactionService {

    private final StockTransactionRepository repository;

    public StockTransactionService(StockTransactionRepository repository) {
        this.repository = repository;
    }

    public List<StockTransaction> getAll() {
        return repository.findAll();
    }

    public List<StockTransaction> getByProduct(Long productId) {
        return repository.findByProductId(productId);
    }
}

