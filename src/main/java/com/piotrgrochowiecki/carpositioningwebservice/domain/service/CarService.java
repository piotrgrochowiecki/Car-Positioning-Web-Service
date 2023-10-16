package com.piotrgrochowiecki.carpositioningwebservice.domain.service;

import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Car;
import com.piotrgrochowiecki.carpositioningwebservice.domain.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CarService {

    final private CarRepository carRepository;

    public String add(Car car) {
        carRepository.save(car);
        return car.uuid();
    }

    public Car getByUuid(String uuid) {
        return carRepository.findByUuid(uuid);
    }

}
