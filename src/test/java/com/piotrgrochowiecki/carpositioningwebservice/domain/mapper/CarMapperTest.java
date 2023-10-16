package com.piotrgrochowiecki.carpositioningwebservice.domain.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.data.entity.CarEntity;
import com.piotrgrochowiecki.carpositioningwebservice.data.entity.PositionEntity;
import com.piotrgrochowiecki.carpositioningwebservice.data.mapper.CarMapper;
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
class CarMapperTest {

    private final CarMapper carMapper;

    @Autowired
    public CarMapperTest(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    @Test
    void shouldReturnCarEntityFromDomainModel() {
        //given
        Position position = Position.builder()
                .carsUuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .time(LocalTime.of(13, 34, 43))
                .date(LocalDate.of(2023, 10, 10))
                .latitude(44.0)
                .longitude(55.0)
                .build();

        PositionEntity positionEntity = PositionEntity.builder()
                .carEntity(CarEntity.builder()
                                   .uuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                                   .build())
                .time(LocalTime.of(13, 34, 43))
                .date(LocalDate.of(2023, 10, 10))
                .latitude(44.0)
                .longitude(55.0)
                .build();

        Car car = Car.builder()
                .uuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .brand("Suzuki")
                .model("e-Swift")
                .positionList(List.of(position))
                .build();

        CarEntity carEntity = CarEntity.builder()
                .uuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .brand("Suzuki")
                .model("e-Swift")
                .positionEntityList(List.of(positionEntity))
                .build();

        //when
        CarEntity result = carMapper.mapToEntity(car);

        //then
        assertThat(result).isEqualTo(carEntity);
    }

    @Test
    void shouldReturnModelDomainFromEntity() {
        //given
        Position position = Position.builder()
                .carsUuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .time(LocalTime.of(13, 34, 43))
                .date(LocalDate.of(2023, 10, 10))
                .latitude(44.0)
                .longitude(55.0)
                .build();

        PositionEntity positionEntity = PositionEntity.builder()
                .carEntity(CarEntity.builder()
                                   .uuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                                   .build())
                .time(LocalTime.of(13, 34, 43))
                .date(LocalDate.of(2023, 10, 10))
                .latitude(44.0)
                .longitude(55.0)
                .build();

        Car car = Car.builder()
                .uuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .brand("Suzuki")
                .model("e-Swift")
                .positionList(List.of(position))
                .build();

        CarEntity carEntity = CarEntity.builder()
                .uuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .brand("Suzuki")
                .model("e-Swift")
                .positionEntityList(List.of(positionEntity))
                .build();

        //when
        Car result = carMapper.mapToModel(carEntity);

        //then
        assertThat(result).isEqualTo(car);

    }

}