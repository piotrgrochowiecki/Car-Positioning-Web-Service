package com.piotrgrochowiecki.carpositioningwebservice.api.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.api.dto.CarDto;
import com.piotrgrochowiecki.carpositioningwebservice.api.dto.PositionDto;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Car;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CarApiMapper {

    public Car mapToDomain(CarDto carDto) {
        return Car.builder()
                .uuid(carDto.uuid())
                .brand(carDto.brand())
                .model(carDto.model())
                .positionList(carDto.positionDtoList()
                                      .stream()
                                      .map(CarApiMapper::positionDtoToDomain)
                                      .collect(Collectors.toList()))
                .build();
    }

    public CarDto mapToDto(Car car) {
        return CarDto.builder()
                .uuid(car.uuid())
                .brand(car.brand())
                .model(car.model())
                .positionDtoList(car.positionList()
                                         .stream()
                                         .map(CarApiMapper::positionDomainToDto)
                                         .collect(Collectors.toList()))
                .build();
    }

    private static PositionDto positionDomainToDto(Position position) {
        return PositionDto.builder()
                .id(position.id())
                .carsUuid(position.carsUuid())
                .time(position.time())
                .date(position.date())
                .longitude(position.longitude())
                .latitude(position.latitude())
                .build();
    }

    private static Position positionDtoToDomain(PositionDto positionDto) {
        return Position.builder()
                .id(positionDto.id())
                .carsUuid(positionDto.carsUuid())
                .time(positionDto.time())
                .date(positionDto.date())
                .longitude(positionDto.longitude())
                .latitude(positionDto.latitude())
                .build();
    }

}
