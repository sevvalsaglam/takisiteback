package com.takisite.backend.dto;

public class ProductRequest {
    private String title;
    private String category;
    private String description;
    private Double price;
    private String image;
    private Double point;

    public ProductRequest() {
    }

    public ProductRequest(String title, String category, String description, Double price, String image, Double point) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.price = price;
        this.image = image;
        this.point = point;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }
}
