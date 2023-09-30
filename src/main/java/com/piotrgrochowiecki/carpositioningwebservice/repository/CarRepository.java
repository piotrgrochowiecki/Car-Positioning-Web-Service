package com.piotrgrochowiecki.carpositioningwebservice.repository;

import com.piotrgrochowiecki.carpositioningwebservice.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Car repository
 */
@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

}
