package com.takisite.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemResponse {
    private Long id;
    private Long productId;
    private String title;
    private String image;
    private Double price;
    private String category;
    private Double point;
    private int quantity;
}

