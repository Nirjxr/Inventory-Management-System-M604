package com.Inventory.Inventory.core;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public abstract class BaseController<T, ID> {

    protected abstract BaseService<T, ID> getService();

    @PostMapping
    public T create(@RequestBody T entity) {
        return getService().create(entity);
    }

    @GetMapping
    public List<T> getAll() {
        return getService().getAll();
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable ID id) {
        return getService().getById(id);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody T entity) {
        return getService().update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        getService().delete(id);
    }
}
