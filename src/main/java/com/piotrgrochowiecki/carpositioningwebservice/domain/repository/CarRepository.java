package com.piotrgrochowiecki.carpositioningwebservice.domain.repository;

import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Car;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository {

    Car findByUuid(@Nullable String uuid);

    boolean existsByUuid(@Nullable String uuid);

    String save(Car car);

}
