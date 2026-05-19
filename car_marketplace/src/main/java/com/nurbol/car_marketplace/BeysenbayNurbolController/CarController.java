package com.nurbol.car_marketplace.BeysenbayNurbolController;

import com.nurbol.car_marketplace.BeysenbayNurbolDTO.Car.CarCreateDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolDTO.Car.CarResponseDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolEntity.Car;
import com.nurbol.car_marketplace.BeysenbayNurbolService.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public CarResponseDTO createCar(
            @RequestBody CarCreateDTO dto
    ) {
        return carService.createCar(dto);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
}