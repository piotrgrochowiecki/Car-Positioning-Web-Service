package com.piotrgrochowiecki.carpositioningwebservice.domain.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.data.entity.CarEntity;
import com.piotrgrochowiecki.carpositioningwebservice.data.entity.PositionEntity;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.google.common.truth.Truth.*;

@SpringBootTest
class PositionMapperTest {

    private final PositionMapper positionMapper;

    @Autowired
    public PositionMapperTest(PositionMapper positionMapper) {
        this.positionMapper = positionMapper;
    }

    @Test
    void shouldReturnPositionEntityTransformedFromDomainModel() {
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

        //when
        PositionEntity result = positionMapper.mapModelToEntity(position);

        //then
        assertThat(result).isEqualTo(positionEntity);
    }

    @Test
    void shouldReturnPositionDomainModelTransformedFromEntity() {
        //given
        Position position = Position.builder()
                .id(1L)
                .carsUuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                .time(LocalTime.of(13, 34, 43))
                .date(LocalDate.of(2023, 10, 10))
                .latitude(44.0)
                .longitude(55.0)
                .build();

        PositionEntity positionEntity = PositionEntity.builder()
                .id(1L)
                .carEntity(CarEntity.builder()
                                   .uuid("967b0945-a9dc-4ae2-bdd0-16a9287df057")
                                   .build())
                .time(LocalTime.of(13, 34, 43))
                .date(LocalDate.of(2023, 10, 10))
                .latitude(44.0)
                .longitude(55.0)
                .build();

        //when
        Position result = positionMapper.mapEntityToModel(positionEntity);

        //then
        assertThat(result).isEqualTo(position);
    }

}