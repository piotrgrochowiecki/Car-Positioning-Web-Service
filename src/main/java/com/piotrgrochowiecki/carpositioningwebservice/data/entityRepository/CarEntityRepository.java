package com.piotrgrochowiecki.carpositioningwebservice.data.entityRepository;

import com.piotrgrochowiecki.carpositioningwebservice.data.entity.CarEntity;
import com.piotrgrochowiecki.carpositioningwebservice.data.repository.CarCRUDRepository;
import com.piotrgrochowiecki.carpositioningwebservice.domain.exception.NotFoundRuntimeException;
import com.piotrgrochowiecki.carpositioningwebservice.domain.exception.ObjectType;
import com.piotrgrochowiecki.carpositioningwebservice.domain.mapper.CarMapper;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Car;
import com.piotrgrochowiecki.carpositioningwebservice.domain.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class CarEntityRepository implements CarRepository {

    private final CarCRUDRepository carCRUDRepository;

    private final CarMapper carMapper;

    public Car findByUuid(@Nullable String uuid) {
        Optional<CarEntity> optionalCarEntity = carCRUDRepository.findCarByUuid(uuid);
        CarEntity carEntity = optionalCarEntity.orElseThrow(() -> new NotFoundRuntimeException(ObjectType.CAR, uuid));
        return carMapper.mapEntityToModel(carEntity);
    }

    public boolean existsByUuid(@Nullable String uuid) {
        return carCRUDRepository.existsByUuid(uuid);
    }

    public void save(@Nullable Car car) {
        assert car != null;
        CarEntity carEntity = carMapper.mapModelToEntity(car);
        carCRUDRepository.save(carEntity);
    }

}
