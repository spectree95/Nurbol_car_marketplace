package com.nurbol.car_marketplace.BeysenbayNurbolRepository;

import com.nurbol.car_marketplace.BeysenbayNurbolEntity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository
        extends JpaRepository<Car, Long> {
}