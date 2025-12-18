package com.Inventory.Inventory.productReview.service;

import com.Inventory.Inventory.productReview.domain.ProductReview;
import com.Inventory.Inventory.productReview.repo.ProductReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductReviewService {
    private final ProductReviewRepository repository;

    public ProductReviewService(ProductReviewRepository repository) {
        this.repository = repository;
    }

    public ProductReview addReview(ProductReview review) {

        if (review.getRating() < 1 || review.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        return repository.save(review);
    }

    public List<ProductReview> getReviewsByProduct(Long productId) {
        return repository.findByProductId(productId);
    }
}
