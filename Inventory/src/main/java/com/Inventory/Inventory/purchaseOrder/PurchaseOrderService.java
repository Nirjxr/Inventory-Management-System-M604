package com.Inventory.Inventory.purchaseOrder;

import com.Inventory.Inventory.core.BaseRepository;
import com.Inventory.Inventory.core.BaseService;
import com.Inventory.Inventory.inventory.Inventory;
import com.Inventory.Inventory.inventory.InventoryRepository;
import com.Inventory.Inventory.stockTransaction.StockTransaction;
import com.Inventory.Inventory.stockTransaction.StockTransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService extends BaseService<PurchaseOrder, Long> {

    private final PurchaseOrderRepository repository;
    private final InventoryRepository inventoryRepository;
    private final StockTransactionRepository transactionRepository;

    public PurchaseOrderService(PurchaseOrderRepository repository, InventoryRepository inventoryRepository, StockTransactionRepository transactionRepository) {
        this.repository = repository;
        this.inventoryRepository = inventoryRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    protected BaseRepository<PurchaseOrder, Long> getRepository() {
        return repository;
    }

    @Override
    protected String getEntityName() {
        return "PurchaseOrder";
    }

    @Transactional
    public PurchaseOrder receiveOrder(Long orderId) {
        PurchaseOrder order = getById(orderId);

        if (!"created".equalsIgnoreCase(order.getStatus())) {
            throw new IllegalStateException("Order cannot be received");
        }

        order.getItems().forEach(item -> {
            Inventory inventory = inventoryRepository
                    .findByProductId(item.getProduct().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Inventory not found"));

            inventory.setAvailableQuantity(
                    inventory.getAvailableQuantity() + item.getQuantity()
            );

            transactionRepository.save(
                    StockTransaction.builder()
                            .product(item.getProduct())
                            .quantity(item.getQuantity())
                            .transactionType("in")
                            .reason("Purchase Order Received")
                            .build()
            );

            inventoryRepository.save(inventory);
        });

        order.setStatus("received");
        return repository.save(order);
    }

    @Override
    public PurchaseOrder create(PurchaseOrder order) {
        if (order.getItems() != null) {
            order.getItems().forEach(item -> {
                item.setPurchaseOrder(order);
            });
        }
        return super.create(order);
    }
}
