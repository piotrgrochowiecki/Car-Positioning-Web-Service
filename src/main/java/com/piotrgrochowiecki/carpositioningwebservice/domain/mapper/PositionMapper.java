package com.piotrgrochowiecki.carpositioningwebservice.domain.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.data.entity.PositionEntity;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.springframework.stereotype.Component;

@Component
public class PositionMapper {

    private final CarMapper carMapper;

    public PositionMapper(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    public PositionEntity mapModelToEntity(Position position) {
        return PositionEntity.builder()
                .time(position.time())
                .date(position.date())
                .latitude(position.latitude())
                .longitude(position.longitude())
                .carEntity(carMapper.mapModelToEntity(position.car()))
                .build();
    }

    public Position mapEntityToModel(PositionEntity positionEntity) {
        return Position.builder()
                .id(positionEntity.getId())
                .time(positionEntity.getTime())
                .date(positionEntity.getDate())
                .latitude(positionEntity.getLatitude())
                .longitude(positionEntity.getLongitude())
                .car(carMapper.mapEntityToModel(positionEntity.getCarEntity()))
                .build();
    }

}
