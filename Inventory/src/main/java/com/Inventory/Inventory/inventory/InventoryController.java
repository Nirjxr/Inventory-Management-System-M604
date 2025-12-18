package com.Inventory.Inventory.inventory;

import com.Inventory.Inventory.core.BaseController;
import com.Inventory.Inventory.core.BaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController extends BaseController<Inventory, Long> {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @Override
    protected BaseService<Inventory, Long> getService() {
        return service;
    }

    @PostMapping("/{productId}/stock-in")
    public Inventory stockIn(@PathVariable Long productId, @RequestParam int quantity, @RequestParam String reason) {
        return service.stockIn(productId, quantity, reason);
    }

    @PostMapping("/{productId}/stock-out")
    public Inventory stockOut(@PathVariable Long productId, @RequestParam int quantity, @RequestParam String reason) {
        return service.stockOut(productId, quantity, reason);
    }
}