package com.piotrgrochowiecki.carpositioningwebservice.repository;

import com.piotrgrochowiecki.carpositioningwebservice.entity.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Car repository
 */
public interface CarRepository extends CrudRepository<Car, Long> {

}
