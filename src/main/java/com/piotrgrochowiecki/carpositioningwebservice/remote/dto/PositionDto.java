package com.piotrgrochowiecki.carpositioningwebservice.remote.dto;


import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record PositionDto(Long id, String carsUuid, LocalDate date, LocalTime time, Double longitude, Double latitude) {

}
