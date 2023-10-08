package com.piotrgrochowiecki.carpositioningwebservice.domain.repository;

import com.piotrgrochowiecki.carpositioningwebservice.data.entity.CarEntity;
import com.piotrgrochowiecki.carpositioningwebservice.data.repository.CarCRUDRepository;
import com.piotrgrochowiecki.carpositioningwebservice.domain.exception.NotFoundException;
import com.piotrgrochowiecki.carpositioningwebservice.domain.mapper.CarMapper;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CarRepository {

    private final CarCRUDRepository carCRUDRepository;

    private final CarMapper carMapper;

    @Autowired
    public CarRepository(CarCRUDRepository carCRUDRepository, CarMapper carMapper) {
        this.carCRUDRepository = carCRUDRepository;
        this.carMapper = carMapper;
    }

    public Car findByUuid(@Nullable String uuid) throws NotFoundException {
        Optional<CarEntity> optionalCarEntity = carCRUDRepository.findCarByUuid(uuid);
        CarEntity carEntity = optionalCarEntity.orElseThrow(() -> new NotFoundException("Car", uuid));
        return carMapper.mapEntityToModel(carEntity);
    }

    public boolean existsByUuid(@Nullable String uuid) {
        return carCRUDRepository.existsByUuid(uuid);
    }

    public void save(Car car) {
        CarEntity carEntity = carMapper.mapModelToEntity(car);
        carCRUDRepository.save(carEntity);
    }

}
