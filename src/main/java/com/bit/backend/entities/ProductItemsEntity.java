package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "product_items")
public class ProductItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_quantity")
    private Double itemQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_items_id", nullable = false)
    private ProductItemsMapEntity productItemsMapEntity;

    public ProductItemsEntity() {
    }

//    public ProductItemsEntity(Long id, Long itemId, String categoryName, Double itemQuantity) {
//        this.id = id;
//        this.itemId = itemId;
//        this.categoryName = categoryName;
//        this.itemQuantity = itemQuantity;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public ProductItemsMapEntity getProductItemsMapEntity() {
        return productItemsMapEntity;
    }

    public void setProductItemsMapEntity(ProductItemsMapEntity productItemsMapEntity) {
        this.productItemsMapEntity = productItemsMapEntity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
