package com.Inventory.Inventory.supplier;

import com.Inventory.Inventory.core.BaseRepository;
import com.Inventory.Inventory.core.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SupplierService extends BaseService<Supplier, Long> {

    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Supplier, Long> getRepository() {
        return repository;
    }

    @Override
    protected String getEntityName() {
        return "Supplier";
    }
}
