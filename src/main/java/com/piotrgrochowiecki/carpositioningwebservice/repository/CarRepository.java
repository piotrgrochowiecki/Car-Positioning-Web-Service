package com.piotrgrochowiecki.carpositioningwebservice.repository;

import com.piotrgrochowiecki.carpositioningwebservice.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Car repository
 */
@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    Optional<Car> findCarByUuid(String uuid);

}
