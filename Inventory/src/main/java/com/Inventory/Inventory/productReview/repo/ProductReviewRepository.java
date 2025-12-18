package com.Inventory.Inventory.productReview.repo;

import com.Inventory.Inventory.productReview.domain.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductReviewRepository extends MongoRepository<ProductReview, String> {
    List<ProductReview> findByProductId(Long productId);
}
