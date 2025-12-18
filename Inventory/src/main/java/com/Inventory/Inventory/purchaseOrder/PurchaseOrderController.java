package com.Inventory.Inventory.purchaseOrder;

import com.Inventory.Inventory.core.BaseController;
import com.Inventory.Inventory.core.BaseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController extends BaseController<PurchaseOrder, Long> {

    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @Override
    protected BaseService<PurchaseOrder, Long> getService() {
        return service;
    }

    @PostMapping("/{id}/receive")
    public PurchaseOrder receiveOrder(@PathVariable Long id) {
        return service.receiveOrder(id);
    }
}

