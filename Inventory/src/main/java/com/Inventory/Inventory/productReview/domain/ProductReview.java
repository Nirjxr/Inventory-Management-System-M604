package com.Inventory.Inventory.productReview.domain;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product_reviews")
@Getter
@Setter
public class ProductReview {

    @Id
    private String id;

    private Long productId;
    private Integer rating;
    private String comment;
}
