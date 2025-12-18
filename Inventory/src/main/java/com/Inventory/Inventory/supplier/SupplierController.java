package com.Inventory.Inventory.supplier;

import com.Inventory.Inventory.core.BaseController;
import com.Inventory.Inventory.core.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController extends BaseController<Supplier, Long> {

    private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @Override
    protected BaseService<Supplier, Long> getService() {
        return service;
    }
}