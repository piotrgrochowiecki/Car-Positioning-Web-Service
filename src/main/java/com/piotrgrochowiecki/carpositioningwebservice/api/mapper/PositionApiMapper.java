package com.piotrgrochowiecki.carpositioningwebservice.api.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.api.dto.CarDto;
import com.piotrgrochowiecki.carpositioningwebservice.api.dto.PositionDto;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Car;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PositionApiMapper {

    private final CarApiMapper carMapper;

    @Autowired
    public PositionApiMapper(CarApiMapper carMapper) {
        this.carMapper = carMapper;
    }

    public Position mapDtoToDomain(PositionDto positionDto) {
        return Position.builder()
                .id(positionDto.id())
                .time(positionDto.time())
                .date(positionDto.date())
                .latitude(positionDto.latitude())
                .longitude(positionDto.longitude())
                .car(carMapper.mapDtoToDomain(positionDto.carDto()))
                .build();
    }


    public PositionDto mapDomainToDto(Position position) {
        return PositionDto.builder()
                .id(position.id())
                .time(position.time())
                .date(position.date())
                .latitude(position.latitude())
                .longitude(position.longitude())
                .carDto(carMapper.mapDomainToDto(position.car()))
                .build();
    }

}
