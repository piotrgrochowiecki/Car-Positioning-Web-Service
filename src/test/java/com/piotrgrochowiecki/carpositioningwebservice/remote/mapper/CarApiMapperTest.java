package com.piotrgrochowiecki.carpositioningwebservice.remote.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.remote.dto.CarDto;
import com.piotrgrochowiecki.carpositioningwebservice.remote.dto.PositionDto;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Car;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.google.common.truth.Truth.*;

@SpringBootTest
class CarApiMapperTest {

    private final CarApiMapper carApiMapper;

    @Autowired
    public CarApiMapperTest(CarApiMapper carApiMapper) {
        this.carApiMapper = carApiMapper;
    }

    @Test
    void shouldReturnDomainModelFromDto() {
        //given
        PositionDto positionDto = PositionDto.builder()
                .carsUuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .time(LocalTime.of(13, 34, 43))
                .date(LocalDate.of(2023, 10, 10))
                .latitude(44.0)
                .longitude(55.0)
                .build();

        Position position = Position.builder()
                .carsUuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .time(LocalTime.of(13, 34, 43))
                .date(LocalDate.of(2023, 10, 10))
                .latitude(44.0)
                .longitude(55.0)
                .build();

        CarDto carDto = CarDto.builder()
                .uuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .brand("Suzuki")
                .model("e-Swift")
                .positionDtoList(List.of(positionDto))
                .build();

        Car car = Car.builder()
                .uuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .brand("Suzuki")
                .model("e-Swift")
                .positionList(List.of(position))
                .build();

        //when
        Car result = carApiMapper.mapToDomain(carDto);

        //then
        assertThat(result).isEqualTo(car);
    }

    @Test
    void shouldReturnDtoFromDomainModel() {
        //given
        PositionDto positionDto = PositionDto.builder()
                .carsUuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .time(LocalTime.of(13, 34, 43))
                .date(LocalDate.of(2023, 10, 10))
                .latitude(44.0)
                .longitude(55.0)
                .build();

        Position position = Position.builder()
                .carsUuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .time(LocalTime.of(13, 34, 43))
                .date(LocalDate.of(2023, 10, 10))
                .latitude(44.0)
                .longitude(55.0)
                .build();

        CarDto carDto = CarDto.builder()
                .uuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .brand("Suzuki")
                .model("e-Swift")
                .positionDtoList(List.of(positionDto))
                .build();

        Car car = Car.builder()
                .uuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .brand("Suzuki")
                .model("e-Swift")
                .positionList(List.of(position))
                .build();

        //when
        CarDto result = carApiMapper.mapToDto(car);

        //then
        assertThat(result).isEqualTo(carDto);
    }

}