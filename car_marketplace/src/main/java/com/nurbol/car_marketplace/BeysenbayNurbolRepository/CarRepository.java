package com.nurbol.car_marketplace.BeysenbayNurbolRepository;

import com.nurbol.car_marketplace.BeysenbayNurbolEntity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarRepository
        extends JpaRepository<Car, Long> {
    Page<Car>
    findByBrandContainingIgnoreCase(
            String brand,
            Pageable pageable
    );
}