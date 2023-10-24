package com.piotrgrochowiecki.carpositioningwebservice.remote.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.remote.dto.PositionDto;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.springframework.stereotype.Component;


@Component
public class PositionApiMapper {

    public Position mapToDomain(PositionDto positionDto) {
        return Position.builder()
                .carsUuid(positionDto.carsUuid())
                .time(positionDto.time())
                .date(positionDto.date())
                .latitude(positionDto.latitude())
                .longitude(positionDto.longitude())
                .build();
    }

    public PositionDto mapToDto(Position position) {
        return PositionDto.builder()
                .id(position.id())
                .carsUuid(position.carsUuid())
                .time(position.time())
                .date(position.date())
                .latitude(position.latitude())
                .longitude(position.longitude())
                .build();
    }

}
