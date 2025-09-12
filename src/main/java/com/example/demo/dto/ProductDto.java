package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ProductDto {
    private Long id;
    @NotBlank(message = "Product name cannot be blank")
    @Size(min = 3, max = 100, message = "Product name must be between 3 and 100 characters")
    private String name;
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;
    @NotNull(message = "Category ID is required")
    private Long categoryId; // Used in request
    private String categoryName; // Used in response

    // Getters and setters
}