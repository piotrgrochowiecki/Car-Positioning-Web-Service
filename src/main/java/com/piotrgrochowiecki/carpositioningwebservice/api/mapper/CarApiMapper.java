package com.piotrgrochowiecki.carpositioningwebservice.api.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.api.dto.CarDto;
import com.piotrgrochowiecki.carpositioningwebservice.api.dto.PositionDto;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Car;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CarApiMapper {

    public Car mapDtoToDomain(CarDto carDto) {
        return Car.builder()
                .uuid(carDto.uuid())
                .brand(carDto.brand())
                .model(carDto.model())
                .positionList(carDto.positionDtoList()
                                      .stream()
                                      .map(positionDtoToDomainFunction)
                                      .collect(Collectors.toList()))
                .build();
    }

    Function<PositionDto, Position> positionDtoToDomainFunction = position -> Position.builder()
            .id(position.id())
            .carsUuid(position.carsUuid())
            .time(position.time())
            .date(position.date())
            .longitude(position.longitude())
            .latitude(position.latitude())
            .build();

    public CarDto mapDomainToDto(Car car) {
        return CarDto.builder()
                .uuid(car.uuid())
                .brand(car.brand())
                .model(car.model())
                .positionDtoList(car.positionList()
                                         .stream()
                                         .map(positionDomainToDtoFunction)
                                         .collect(Collectors.toList()))
                .build();
    }

    Function<Position, PositionDto> positionDomainToDtoFunction = position -> PositionDto.builder()
            .id(position.id())
            .carsUuid(position.carsUuid())
            .time(position.time())
            .date(position.date())
            .longitude(position.longitude())
            .latitude(position.latitude())
            .build();

}
