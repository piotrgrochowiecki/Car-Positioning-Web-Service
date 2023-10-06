package com.piotrgrochowiecki.carpositioningwebservice.domain.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.data.entity.CarEntity;
import com.piotrgrochowiecki.carpositioningwebservice.data.entity.PositionEntity;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Car;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import com.piotrgrochowiecki.carpositioningwebservice.domain.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PositionMapper {

    private final CarRepository carRepository;
    @Autowired
    public PositionMapper(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public PositionEntity mapModelToEntity(Position position) {
        return PositionEntity.builder()
                .time(position.time())
                .date(position.date())
                .latitude(position.latitude())
                .longitude(position.longitude())
                .carEntity(CarEntity.builder()
                                   .uuid(position.carsUuid())
                                   .build())
                .build();
    }

    public Position mapEntityToModel(PositionEntity positionEntity) {
        return Position.builder()
                .id(positionEntity.getId())
                .carsUuid(positionEntity.getCarEntity().getUuid())
                .time(positionEntity.getTime())
                .date(positionEntity.getDate())
                .latitude(positionEntity.getLatitude())
                .longitude(positionEntity.getLongitude())
                .build();
    }

}
