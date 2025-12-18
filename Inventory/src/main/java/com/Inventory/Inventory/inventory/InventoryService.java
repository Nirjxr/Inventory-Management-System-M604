package com.Inventory.Inventory.inventory;

import com.Inventory.Inventory.core.BaseRepository;
import com.Inventory.Inventory.core.BaseService;
import com.Inventory.Inventory.stockTransaction.StockTransaction;
import com.Inventory.Inventory.stockTransaction.StockTransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class InventoryService extends BaseService<Inventory, Long> {

    private final InventoryRepository repository;
    private final StockTransactionRepository transactionRepository;

    public InventoryService(InventoryRepository repository, StockTransactionRepository transactionRepository) {
        this.repository = repository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    protected BaseRepository<Inventory, Long> getRepository() {
        return repository;
    }

    @Override
    protected String getEntityName() {
        return "Inventory";
    }

    @Transactional
    public Inventory stockIn(Long productId, int quantity, String reason) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        Inventory inventory = repository.findByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found"));

        inventory.setAvailableQuantity(
                inventory.getAvailableQuantity() + quantity
        );

        transactionRepository.save(
                StockTransaction.builder()
                        .product(inventory.getProduct())
                        .quantity(quantity)
                        .transactionType("IN")
                        .reason(reason)
                        .build()
        );

        return repository.save(inventory);
    }

    @Transactional
    public Inventory stockOut(Long productId, int quantity, String reason) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        Inventory inventory = repository.findByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found"));

        if (inventory.getAvailableQuantity() < quantity) {
            throw new IllegalStateException("Insufficient stock");
        }

        inventory.setAvailableQuantity(
                inventory.getAvailableQuantity() - quantity
        );

        transactionRepository.save(
                StockTransaction.builder()
                        .product(inventory.getProduct())
                        .quantity(quantity)
                        .transactionType("OUT")
                        .reason(reason)
                        .build()
        );

        return repository.save(inventory);
    }
}
