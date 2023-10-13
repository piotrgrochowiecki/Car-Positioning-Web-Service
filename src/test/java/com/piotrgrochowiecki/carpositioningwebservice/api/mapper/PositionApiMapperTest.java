package com.piotrgrochowiecki.carpositioningwebservice.api.mapper;

import com.piotrgrochowiecki.carpositioningwebservice.api.dto.PositionDto;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.google.common.truth.Truth.*;

@SpringBootTest
class PositionApiMapperTest {

    private final PositionApiMapper positionApiMapper;

    @Autowired
    public PositionApiMapperTest(PositionApiMapper positionApiMapper) {
        this.positionApiMapper = positionApiMapper;
    }

    @Test
    void shouldReturnDomainModelFromPositionDto() {
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

        //when
        Position result = positionApiMapper.mapToDomain(positionDto);

        //then
        assertThat(result).isEqualTo(position);
    }

    @Test
    void shouldReturnPositionDtoFromDomainModel() {
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

        //when
        PositionDto result = positionApiMapper.mapToDto(position);

        //then
        assertThat(result).isEqualTo(positionDto);
    }

}