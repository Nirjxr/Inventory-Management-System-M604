package com.Inventory.Inventory.inventory;

import com.Inventory.Inventory.core.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends BaseRepository<Inventory, Long> {
    Optional<Inventory> findByProductId(Long productId);
}