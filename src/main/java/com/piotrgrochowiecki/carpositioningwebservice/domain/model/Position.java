package com.piotrgrochowiecki.carpositioningwebservice.domain.model;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record Position(Long id,String carsUuid, LocalDate date, LocalTime time, Double longitude, Double latitude) {

}
