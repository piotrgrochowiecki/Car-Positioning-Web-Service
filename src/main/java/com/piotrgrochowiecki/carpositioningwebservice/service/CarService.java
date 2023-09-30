package com.piotrgrochowiecki.carpositioningwebservice.service;

import com.piotrgrochowiecki.carpositioningwebservice.entity.Car;

import java.util.Optional;

/**
 * Car service
 */
public interface CarService {

    void add(Car car);

    Optional<Car> getByUuid(String uuid);

}
