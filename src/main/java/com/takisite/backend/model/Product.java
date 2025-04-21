package com.takisite.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    private Long id; // ID’ler frontend'den geliyorsa elle verilebilir

    private String title;
    private String category;
    private Double price;

    @Column(length = 1000)
    private String description;

    private String image;
    private Double point; // 0.0 – 5.0 arası

    // Favoriler ve Sepet ilişkileri tersten yazılmaz çünkü bu tarafa ihtiyacımız olmayacak
}
