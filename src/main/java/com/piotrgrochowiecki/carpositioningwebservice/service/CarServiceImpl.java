package com.piotrgrochowiecki.carpositioningwebservice.service;

import com.piotrgrochowiecki.carpositioningwebservice.entity.Car;
import com.piotrgrochowiecki.carpositioningwebservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Car service implementation
 */
@Service
public class CarServiceImpl implements CarService {

    final private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void add(Car car) {
        carRepository.save(car);
    }

}
