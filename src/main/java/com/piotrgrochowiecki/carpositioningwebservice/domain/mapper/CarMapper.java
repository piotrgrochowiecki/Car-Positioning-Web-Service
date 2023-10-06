package com.piotrgrochowiecki.carpositioningwebservice.domain.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.data.entity.CarEntity;
import com.piotrgrochowiecki.carpositioningwebservice.data.entity.PositionEntity;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Car;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CarMapper {

    public CarEntity mapModelToEntity(Car car) {
        return CarEntity.builder()
                .uuid(car.uuid())
                .brand(car.brand())
                .model(car.model())
                .positionEntityList(car.positionList()
                                      .stream()
                                      .map(positionModelToEntityFunction)
                                      .collect(Collectors.toList()))
                .build();
    }

    Function<Position, PositionEntity> positionModelToEntityFunction = position -> PositionEntity.builder()
            .id(position.id())
            .time(position.time())
            .date(position.date())
            .longitude(position.longitude())
            .latitude(position.latitude())
            .build();

    public Car mapEntityToModel(CarEntity carEntity) {
        return Car.builder()
                .uuid(carEntity.getUuid())
                .brand(carEntity.getBrand())
                .model(carEntity.getModel())
                .positionList(carEntity.getPositionEntityList()
                                      .stream()
                                      .map(positionEntityToModelFunction)
                                      .collect(Collectors.toList()))
                .build();
    }

    Function<PositionEntity, Position> positionEntityToModelFunction = positionEntity -> Position.builder()
            .id(positionEntity.getId())
            .carsUuid(positionEntity.getCarEntity().getUuid())
            .time(positionEntity.getTime())
            .date(positionEntity.getDate())
            .longitude(positionEntity.getLongitude())
            .latitude(positionEntity.getLatitude())
            .build();

}
