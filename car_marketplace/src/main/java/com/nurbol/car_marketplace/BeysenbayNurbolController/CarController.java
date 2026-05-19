package com.nurbol.car_marketplace.BeysenbayNurbolController;
import java.io.IOException;
import com.nurbol.car_marketplace.BeysenbayNurbolDTO.Car.CarCreateDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolDTO.Car.CarResponseDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolEntity.Car;
import com.nurbol.car_marketplace.BeysenbayNurbolService.CarService;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public CarResponseDTO createCar(
            @Valid @RequestBody CarCreateDTO dto
    ) {
        return carService.createCar(dto);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/search")
    public Page<Car> searchCars(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size,

            @RequestParam(defaultValue = "price")
            String sortBy,

            @RequestParam(defaultValue = "")
            String brand
    ) {

        return carService.getCars(
                page,
                size,
                sortBy,
                brand
        );
    }
    @PostMapping(
            value = "/upload/{id}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String uploadCarImage(

            @PathVariable Long id,

            @RequestParam("file")
            MultipartFile file

    ) throws IOException {

        return carService.uploadImage(id, file);
    }
}