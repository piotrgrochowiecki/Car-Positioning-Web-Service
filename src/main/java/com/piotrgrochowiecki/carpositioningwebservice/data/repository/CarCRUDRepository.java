package com.piotrgrochowiecki.carpositioningwebservice.data.repository;

import com.piotrgrochowiecki.carpositioningwebservice.data.entity.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarCRUDRepository extends CrudRepository<CarEntity, Long> {

    Optional<CarEntity> findCarByUuid(String uuid);

    boolean existsByUuid(String uuid);

}
