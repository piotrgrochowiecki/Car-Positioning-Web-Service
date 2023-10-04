package com.piotrgrochowiecki.carpositioningwebservice.domain.model;

import lombok.Builder;

import java.util.List;

@Builder
public record Car(String uuid, String brand, String model, List<Position> positionList) {

}
