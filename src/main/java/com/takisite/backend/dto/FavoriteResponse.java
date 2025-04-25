package com.takisite.backend.dto;

public class FavoriteResponse {
    private Long id;
    private Long productId;
    private String title;
    private String image;
    private Double price;
    private String category;
    private Double point;

    public FavoriteResponse() {}

    public FavoriteResponse(Long id, Long productId, String title, String image, Double price, String category, Double point) {
        this.id = id;
        this.productId = productId;
        this.title = title;
        this.image = image;
        this.price = price;
        this.category = category;
        this.point = point;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getPoint() { return point; }
    public void setPoint(Double point) { this.point = point; }
}
