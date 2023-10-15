package com.piotrgrochowiecki.carpositioningwebservice.data.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.data.entity.CarEntity;
import com.piotrgrochowiecki.carpositioningwebservice.data.entity.PositionEntity;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.springframework.stereotype.Component;

@Component
public class PositionMapper {

    public PositionEntity mapToEntity(Position position) {
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

    public Position mapToModel(PositionEntity positionEntity) {
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
