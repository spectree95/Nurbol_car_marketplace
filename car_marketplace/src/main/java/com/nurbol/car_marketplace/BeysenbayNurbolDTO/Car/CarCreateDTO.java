package com.nurbol.car_marketplace.BeysenbayNurbolDTO.Car;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CarCreateDTO {
    @Min(value = 1, message = "Price must be positive")
    private Integer year;

    private String description;

    @NotBlank(message = "Brand cannot be empty")
    private String brand;

    @NotBlank(message = "Model cannot be empty")
    private String model;

    @Min(value = 1, message = "Price must be positive")
    private Double price;
}