package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Double discountPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Integer numberOfPurchases = 0;
    private Boolean onSale;
    private LocalDateTime createdDate;



}