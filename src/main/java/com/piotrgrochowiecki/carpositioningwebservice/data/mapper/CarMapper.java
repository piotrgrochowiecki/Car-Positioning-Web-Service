package com.piotrgrochowiecki.carpositioningwebservice.data.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.data.entity.CarEntity;
import com.piotrgrochowiecki.carpositioningwebservice.data.entity.PositionEntity;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Car;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CarMapper {

    public CarEntity mapToEntity(Car car) {
        return CarEntity.builder()
                .uuid(car.uuid())
                .brand(car.brand())
                .model(car.model())
                .positionEntityList(car.positionList()
                                      .stream()
                                      .map(CarMapper::positionModelToEntity)
                                      .collect(Collectors.toList()))
                .build();
    }

    public Car mapToModel(CarEntity carEntity) {
        return Car.builder()
                .uuid(carEntity.getUuid())
                .brand(carEntity.getBrand())
                .model(carEntity.getModel())
                .positionList(carEntity.getPositionEntityList()
                                      .stream()
                                      .map(CarMapper::positionEntityToModel)
                                      .collect(Collectors.toList()))
                .build();
    }

    private static PositionEntity positionModelToEntity(Position position){
        return PositionEntity.builder()
                .id(position.id())
                .time(position.time())
                .date(position.date())
                .longitude(position.longitude())
                .latitude(position.latitude())
                .build();
    }

    private static Position positionEntityToModel(PositionEntity positionEntity){
       return Position.builder()
               .id(positionEntity.getId())
               .carsUuid(positionEntity.getCarEntity().getUuid())
               .time(positionEntity.getTime())
               .date(positionEntity.getDate())
               .longitude(positionEntity.getLongitude())
               .latitude(positionEntity.getLatitude())
               .build();
    }

}
