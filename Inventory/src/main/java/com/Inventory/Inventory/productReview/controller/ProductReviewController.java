package com.Inventory.Inventory.productReview.controller;

import com.Inventory.Inventory.productReview.domain.ProductReview;
import com.Inventory.Inventory.productReview.service.ProductReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ProductReviewController {
    private final ProductReviewService service;

    public ProductReviewController(ProductReviewService service) {
        this.service = service;
    }

    @PostMapping
    public ProductReview addReview(@RequestBody ProductReview review) {
        return service.addReview(review);
    }

    @GetMapping("/product/{productId}")
    public List<ProductReview> getReviewsByProduct(
            @PathVariable Long productId) {
        return service.getReviewsByProduct(productId);
    }
}
