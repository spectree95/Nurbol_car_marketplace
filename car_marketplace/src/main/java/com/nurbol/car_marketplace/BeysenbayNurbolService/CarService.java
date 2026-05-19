package com.nurbol.car_marketplace.BeysenbayNurbolService;

import com.nurbol.car_marketplace.BeysenbayNurbolDTO.Car.CarCreateDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolDTO.Car.CarResponseDTO;
import com.nurbol.car_marketplace.BeysenbayNurbolEntity.Car;
import com.nurbol.car_marketplace.BeysenbayNurbolNotificationService.NotificationService;
import com.nurbol.car_marketplace.BeysenbayNurbolRepository.CarRepository;
import com.nurbol.car_marketplace.BeysenbayNurbolRepository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {


    private final NotificationService notificationService;
    @Value("${file.upload-dir}")
    private String uploadDir;
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    public CarResponseDTO createCar(CarCreateDTO dto) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("Пользователь не авторизован");
        }
        String email = authentication.getName();

        Car car = new Car();
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setPrice(dto.getPrice());
        car.setYear(dto.getYear());
        car.setDescription(dto.getDescription());

        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        car.setOwner(user);
        var savedCar = carRepository.save(car);

        CarResponseDTO response = new CarResponseDTO();
        response.setId(savedCar.getId());
        response.setBrand(savedCar.getBrand());
        response.setModel(savedCar.getModel());
        response.setPrice(savedCar.getPrice());
        response.setYear(savedCar.getYear());
        response.setDescription(savedCar.getDescription());
        notificationService
                .sendEmailNotification(
                        user.getEmail()
                );
        return response;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }


    public Page<Car> getCars(
            int page,
            int size,
            String sortBy,
            String brand
    ) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy)
        );

        return carRepository
                .findByBrandContainingIgnoreCase(
                        brand,
                        pageable
                );
    }
    public String uploadImage(
            Long carId,
            MultipartFile file
    ) throws IOException {

        var car = carRepository.findById(carId)
                .orElseThrow(() ->
                        new RuntimeException("Car not found"));

        String fileName =
                System.currentTimeMillis()
                        + "_"
                        + file.getOriginalFilename();

        Path path = Paths.get(uploadDir, fileName);

        Files.createDirectories(path.getParent());

        Files.write(path, file.getBytes());

        car.setImageUrl(fileName);

        carRepository.save(car);
        notificationService
                .processImage(fileName);
        return fileName;
    }
}