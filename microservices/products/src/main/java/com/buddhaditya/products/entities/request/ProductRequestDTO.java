package com.buddhaditya.products.entities.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
    private String name;
    private String description;
    private String category;
    private Double price;
    private Integer stockQuantity;
    private String brand;
    private String imageUrl;
}

