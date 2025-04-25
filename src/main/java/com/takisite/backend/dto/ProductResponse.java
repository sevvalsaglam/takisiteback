package com.takisite.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String title;
    private String category;
    private String description;
    private Double price;
    private String image;
    private Double point;
}
