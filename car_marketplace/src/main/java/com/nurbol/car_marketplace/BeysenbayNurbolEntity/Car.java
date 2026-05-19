package com.nurbol.car_marketplace.BeysenbayNurbolEntity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class Car{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private Double price;

    private Integer year;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    private String imageUrl;
}