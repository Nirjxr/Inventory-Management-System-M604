package com.Inventory.Inventory.category;

import com.Inventory.Inventory.core.BaseRepository;
import com.Inventory.Inventory.core.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category, Long> {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Category, Long> getRepository() {
        return repository;
    }

    @Override
    protected String getEntityName() {
        return "Category";
    }
}