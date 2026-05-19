package com.nurbol.car_marketplace.BeysenbayNurbolService;
import com.nurbol.car_marketplace.BeysenbayNurbolDTO.Car.CarCreateDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolDTO.Car.CarResponseDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolEntity.Car;
import com.nurbol.car_marketplace.BeysenbayNurbolRepository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public CarResponseDTO createCar(CarCreateDTO dto) {

        Car car =
                new Car();

        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setPrice(dto.getPrice());
        car.setYear(dto.getYear());
        car.setDescription(dto.getDescription());

        var savedCar = carRepository.save(car);

        CarResponseDTO response = new CarResponseDTO();

        response.setId(savedCar.getId());
        response.setBrand(savedCar.getBrand());
        response.setModel(savedCar.getModel());
        response.setPrice(savedCar.getPrice());
        response.setYear(savedCar.getYear());
        response.setDescription(savedCar.getDescription());

        return response;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}