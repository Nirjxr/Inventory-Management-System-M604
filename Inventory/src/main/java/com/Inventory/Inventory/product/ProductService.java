package com.Inventory.Inventory.product;

import com.Inventory.Inventory.core.BaseRepository;
import com.Inventory.Inventory.core.BaseService;
import com.Inventory.Inventory.inventory.Inventory;
import com.Inventory.Inventory.inventory.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<Product, Long> {

    private final ProductRepository repository;
    private final InventoryRepository inventoryRepository;

    public ProductService(ProductRepository repository, InventoryRepository inventoryRepository) {
        this.repository = repository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    protected BaseRepository<Product, Long> getRepository() {
        return repository;
    }

    @Override
    protected String getEntityName() {
        return "Product";
    }

    @Override
    public Product create(Product product) {
        Product savedProduct = super.create(product);

        Inventory inventory = Inventory.builder()
                .product(savedProduct)
                .availableQuantity(0)
                .reservedQuantity(0)
                .build();
        inventoryRepository.save(inventory);
        return savedProduct;
    }
}
