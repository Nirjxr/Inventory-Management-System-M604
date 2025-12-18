package com.Inventory.Inventory.purchaseOrder;

import com.Inventory.Inventory.core.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends BaseRepository<PurchaseOrder, Long> {
}