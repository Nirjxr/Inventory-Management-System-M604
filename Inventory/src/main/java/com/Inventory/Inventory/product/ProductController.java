package com.Inventory.Inventory.product;

import com.Inventory.Inventory.core.BaseController;
import com.Inventory.Inventory.core.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController extends BaseController<Product, Long> {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @Override
    protected BaseService<Product, Long> getService() {
        return service;
    }


}
