package com.nurbol.car_marketplace.BeysenbayNurbolDTO.Car;

import lombok.Data;

@Data
public class CarResponseDTO {

    private Long id;
    private String brand;
    private String model;
    private Double price;
    private Integer year;
    private String description;
}